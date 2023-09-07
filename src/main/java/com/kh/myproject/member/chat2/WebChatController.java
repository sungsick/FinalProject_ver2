package com.kh.myproject.member.chat2;


import com.kh.myproject.member.user.model.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class WebChatController {



    @PostMapping("/getUserNumber")
    @ResponseBody
    public Long getUserNumber(@ModelAttribute ("user") User user){


        return user.getUserNumber();
    }


}
