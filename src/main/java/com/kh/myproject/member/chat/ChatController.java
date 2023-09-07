package com.kh.myproject.member.chat;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {

    @RequestMapping("chatTest1")
    public String chatTest(){


        return "member/chat/chatTest";
    }


    @RequestMapping("chatTest3")
    public String chatTest3(){


        return "member/chat/chatTest3";
    }
}
