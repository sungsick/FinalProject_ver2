package com.kh.myproject.member.chat2.service;


import com.kh.myproject.member.chat2.model.ChatMessage;
import com.kh.myproject.member.chat2.model.ChatRoom;
import com.kh.myproject.member.chat2.repository.ChatMessageRepository;
import com.kh.myproject.member.chat2.repository.ChatRoomRepository;
import com.kh.myproject.member.user.model.entity.User;
import com.kh.myproject.member.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageService {

    @Autowired
    ChatMessageRepository chatMessageRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ChatRoomRepository chatRoomRepository;


    public void saveMessage(Long roomId, Long userNumber,String content){

        ChatMessage chatMessage = new ChatMessage();
        ChatRoom chatRoom = chatRoomRepository.findById(roomId).orElse(null);
        User user = userRepository.findById(userNumber).orElse(null);

        chatMessage.setUser(user);
        chatMessage.setChatRoom(chatRoom);
        chatMessage.setContent(content);

        chatMessageRepository.save(chatMessage);
        System.out.println("chatmessage저장완료 saveMessage 메서드");

    }

    public List<ChatMessage> getAllMessage(Long roomId){

        ChatRoom chatRoom = chatRoomRepository.findById(roomId).orElse(null);
        List<ChatMessage> chatMessageList = chatMessageRepository.findAllByChatRoomOrderByMessageIdAsc(chatRoom);

        return chatMessageList;
    }
}
