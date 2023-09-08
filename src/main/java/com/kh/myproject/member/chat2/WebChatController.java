package com.kh.myproject.member.chat2;


import com.kh.myproject.member.chat2.model.ChatMessage;
import com.kh.myproject.member.chat2.service.ChatMessageService;
import com.kh.myproject.member.chat2.service.ChatRoomService;
import com.kh.myproject.member.user.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@SessionAttributes({"user","user2","user3","user4"})

public class WebChatController {


    @Autowired
    ChatRoomService chatRoomService;

    @Autowired
    ChatMessageService chatMessageService;


    @PostMapping("/getUserNumber")
    @ResponseBody
    public Map<String,Object> getUserNumber(HttpSession session){



        // userNumber와 함꼐 해당 userNumber가 갖고 있는 채팅방의 목록도 함께 반환해야한다

        Map<String, Object> userInfo = new HashMap<>();
        long userNumber = -1;

        // null 일수 있기 때문에 sessionㄱ 객체로 뽑아낸다
        User user = (User)session.getAttribute("user");
        List<Long> roomList = null;

        User user2 = (User)session.getAttribute("user2");
        User user3 = (User)session.getAttribute("user3");
        List<User> userList = new ArrayList<>();
        userList.add(user2);
        userList.add(user3);

        if(user != null) { // user1로 로그인된 상태라면 user2나 3이나 4로 userNumber를 얻을것.

            userNumber = user.getUserNumber();
            roomList = chatRoomService.getChatRoomList(userNumber);
            for (int i = 0; i < userList.size(); i++) {

                if (userList.get(i) != null) {
                    userNumber = userList.get(i).getUserNumber();
                    roomList = chatRoomService.getChatRoomList(userList.get(i).getUserNumber());
                    user = userList.get(i);
                    break;
                }
            }

        }

        // 여기도 바꿔야하낟. 테스트하려면.
        userInfo.put("user",user);
        userInfo.put("roomList",roomList);
        return userInfo;
    }

    @GetMapping("addSession2")
    public String addSession2(Model model){


        User user = new User();
        long userNumber = 2;

        user.setUserNumber(userNumber);
        model.addAttribute("user2",user);

        return "community/home";

    }

    @GetMapping("addSession3")
    public String StringaddSession3(Model model){


        User user = new User();
        long userNumber = 3;

        user.setUserNumber(userNumber);

        model.addAttribute("user3",user);
        return "community/home";
    }

    @GetMapping("addSession4")
    public String addSession4(Model model){


        User user = new User();
        long userNumber = 4;

        user.setUserNumber(userNumber);

         model.addAttribute("user4",user);
        return "community/home";


    }

    @PostMapping("/getMessageList")
    @ResponseBody
    public List<ChatMessage> getMessageList(@ModelAttribute("roomId")Long roomId){

        List<ChatMessage> chatMessageList = chatMessageService.getAllMessage(roomId);


        return chatMessageList;
    }


    @RequestMapping("chatTest")
    public String chatTest(Model model, HttpSession session){

        User user = (User)session.getAttribute("user");
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setSendTime(new Date());


        chatMessage.setContent("안녕하세요");

        model.addAttribute("user",user);
        model.addAttribute("chatMessage",chatMessage);


        return "member/chat/chatTest";
    }
}
