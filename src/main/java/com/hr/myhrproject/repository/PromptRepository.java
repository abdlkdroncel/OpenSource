package com.hr.myhrproject.repository;

import com.hr.myhrproject.entity.ChatGptPrompt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PromptRepository extends CrudRepository<ChatGptPrompt,Long> {

    ChatGptPrompt findByPrompt(String prompt);
    List<ChatGptPrompt> findAll();
}
