package com.kh.myproject.member.chat2.repository;

import com.kh.myproject.member.chat2.model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    @Query("select ch.roomId from ChatRoom ch where ch.user1.userNumber = :userNumber or ch.user2 = :userNumber")
    List<Long> selectChatRoomByUserNumber(@Param("userNumber")Long userNumber);
}
