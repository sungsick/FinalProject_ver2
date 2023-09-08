package com.kh.myproject.member.chat2.repository;

import com.kh.myproject.member.chat2.model.ChatMessage;
import com.kh.myproject.member.chat2.model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {


    List<ChatMessage> findAllByChatRoomOrderByMessageIdAsc(ChatRoom chatRoom);
}
