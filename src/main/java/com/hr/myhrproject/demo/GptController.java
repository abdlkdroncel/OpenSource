package com.hr.myhrproject.demo;

import com.hr.myhrproject.entity.ChatGPTRequest;
import com.hr.myhrproject.entity.ChatGPTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/gpt")
public class GptController {

    @Autowired private RestTemplate restTemplate;

    @GetMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt){
        ChatGPTRequest request=new ChatGPTRequest("gpt-3.5-turbo", prompt);
        ChatGPTResponse chatGptResponse = restTemplate.postForObject("https://api.openai.com/v1/chat/completions", request, ChatGPTResponse.class);
        return chatGptResponse.getChoices().get(0).getMessage().getContent();
    }
}
