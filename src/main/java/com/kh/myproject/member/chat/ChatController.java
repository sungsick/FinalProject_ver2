package com.kh.myproject.member.chat;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {




    @RequestMapping("chatTest3")
    public String chatTest3(){


        return "member/chat/chatTest3";
    }
}
