package com.hr.myhrproject.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("chatgptprompt")
public class ChatGptPrompt implements Serializable {

    @Id
    private String id;
    @Indexed
    private String prompt;
    private String message;
}
