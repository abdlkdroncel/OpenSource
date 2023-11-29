package com.hr.myhrproject.service;

import com.hr.myhrproject.entity.ChatGptPrompt;
import com.hr.myhrproject.repository.PromptRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PromptService {

    private final PromptRepository promptRepository;

    public ChatGptPrompt save(ChatGptPrompt prompt){
        return promptRepository.save(prompt);
    }

    public ChatGptPrompt findChatGptPromptByPrompt(String prompt){
        return promptRepository.findChatGptPromptByPrompt(prompt);
    }

    public List<ChatGptPrompt> getAll(){
        return promptRepository.findAll();
    }

}
