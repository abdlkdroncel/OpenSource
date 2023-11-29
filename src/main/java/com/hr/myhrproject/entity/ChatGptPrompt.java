package com.hr.myhrproject.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("chatgptprompt")
public class ChatGptPrompt implements Serializable {

    private String id;
    private String prompt;
    private String message;
}
