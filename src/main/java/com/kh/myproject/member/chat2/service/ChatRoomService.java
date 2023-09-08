package com.kh.myproject.member.chat2.service;

import com.kh.myproject.member.chat2.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChatRoomService {

    @Autowired
    ChatRoomRepository chatRoomRepository;


    public List<Long> getChatRoomList(Long userNumber){


        return chatRoomRepository.selectChatRoomByUserNumber(userNumber);
    }
}
