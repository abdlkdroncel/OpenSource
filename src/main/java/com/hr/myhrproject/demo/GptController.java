package com.hr.myhrproject.demo;

import com.hr.myhrproject.entity.ChatGPTRequest;
import com.hr.myhrproject.entity.ChatGPTResponse;
import com.hr.myhrproject.entity.ChatGptPrompt;
import com.hr.myhrproject.service.PromptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/gpt")
public class GptController {

    @Autowired private RestTemplate restTemplate;
    @Autowired private PromptService promptService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @GetMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt){
        ChatGptPrompt chatGptPrompt=new ChatGptPrompt();
        List<ChatGptPrompt> all = promptService.getAll();
        String message="";
        ChatGptPrompt test = promptService.findChatGptPromptByPrompt(prompt);
        Set<String> keys = redisTemplate.keys("chatgptprompt");

        if(all.contains(prompt)){
            ChatGptPrompt chat = all.stream().filter(t -> t.getPrompt().equals(prompt)).findFirst().get();
            message=chat.getMessage();
        }else{
            ChatGPTRequest request=new ChatGPTRequest("gpt-3.5-turbo", prompt);
            ChatGPTResponse chatGptResponse = restTemplate.postForObject("https://api.openai.com/v1/chat/completions", request, ChatGPTResponse.class);

            message=chatGptResponse.getChoices().get(0).getMessage().getContent();

            ChatGptPrompt chatGptPromptByPromt = promptService.findChatGptPromptByPrompt(prompt);
            chatGptPrompt.setMessage(chatGptResponse.getChoices().get(0).getMessage().getContent());
            chatGptPrompt.setPrompt(prompt);
            ChatGptPrompt save = promptService.save(chatGptPrompt);
        }



        return message;
    }
}
