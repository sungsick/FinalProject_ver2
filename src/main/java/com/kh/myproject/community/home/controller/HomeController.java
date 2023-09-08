package com.kh.myproject.community.home.controller;

import com.kh.myproject.community.accompany.entity.Accompany;
import com.kh.myproject.community.home.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
@Controller
@SessionAttributes("user")
public class HomeController {

    @Autowired
    HomeService homeService;


    @GetMapping("/community/home")
    public String communityHome(Model model){

        List<Accompany> accompanyRecent = homeService.findTop8byOrderByRegdateAsc();
        System.out.println(accompanyRecent);
        model.addAttribute("accompanyList", accompanyRecent);


        return "community/home";
    }

}
