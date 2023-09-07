package com.kh.myproject.member.chat2.repository;

import com.kh.myproject.member.chat2.model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
}
