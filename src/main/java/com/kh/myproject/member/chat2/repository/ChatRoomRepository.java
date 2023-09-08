package com.kh.myproject.member.chat2.repository;

import com.kh.myproject.member.chat2.model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    // 조인을 이용해 message의 sendTime이 가장 최근인 방먼저 골라오도록 해야한다.
    @Query("select ch from ChatRoom ch where ch.user1.userNumber = :userNumber or ch.user2 = :userNumber order by ch.roomId")
    List<ChatRoom> selectChatRoomByUserNumber(@Param("userNumber")Long userNumber);
//
//    @Query("SELECT r FROM ChatRoom r " +
//            "INNER JOIN ChatMessage m ON r.roomId = m.chatRoom.roomId " +
//            "WHERE r.user1.userNumber = :userNumber OR r.user2.userNumber = :userNumber " +
//            "ORDER BY m.sendTime DESC")
//    List<ChatRoom> selectChatRoomByUserNumberOrderBySendTime(@Param("userNumber")Long userNumber);
}
