package com.kh.myproject.member.chat2.repository;

import com.kh.myproject.member.chat2.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
}
