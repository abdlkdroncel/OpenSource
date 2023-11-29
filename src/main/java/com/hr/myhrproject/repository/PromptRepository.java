package com.hr.myhrproject.repository;

import com.hr.myhrproject.entity.ChatGptPrompt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PromptRepository extends JpaRepository<ChatGptPrompt,Long> {

    ChatGptPrompt findChatGptPromptByPrompt(String prompt);
}
