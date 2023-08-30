package com.kh.myproject.member.user.controller;


import com.kh.myproject.member.user.model.entity.Manager;
import com.kh.myproject.member.user.model.entity.User;
import com.kh.myproject.member.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes("manager")
public class ManagerController {

    @Autowired
    UserRepository userRepository;


    // 매니저 뷰페이지는 크게 N가지로 나눈다.
    // 처음 메인 페이지를 보여주고
    // 그다음 여러개의 관리 페이지를 둔다.
    // 일정 게시글, 동행 , 렌트카 예약내역, 항공권 예약내역, 문의글 (답변 가능해야함)

    @GetMapping("/manager/home")
    public ModelAndView managerHome(
            @ModelAttribute("check_manager") Manager check_manager,
            ModelAndView modelAndView,
            HttpSession session) {

        System.out.println(check_manager);

        if (check_manager.getManagerId() != null || session.getAttribute("manager") != null) {
            //세션값이 있거나 userCOntroller에서 로그인 요청이 들어왔다면

            System.out.println("매니저 로그인입니다.");
            modelAndView.setViewName("/member/manager/home");
            modelAndView.addObject("manager", check_manager);
            // 유저 세션은 남아있지 않은 상태일 것.
        } else {

            // url로 접속했을 경우 에러페이지로 이동시킨다.
            modelAndView.setViewName("redirect:/errorPage");

        }

        return modelAndView;
    }

    @GetMapping("/manager/userList")
    public String userList(Model model) {

        List<User> userList = userRepository.findAll();
        model.addAttribute("userList",userList);


        return "member/manager/userList";
    }

    @GetMapping("/manager/accompanyList")
    public String accompanyList() {

        return "member/manager/accompanyList";
    }


    @GetMapping("/manager/flightList")
    public String flightList() {

        return "member/manager/flightList";
    }

    @GetMapping("/manager/rentcarList")
    public String rentcarList() {

        return "member/manager/rentcarList";
    }

    @GetMapping("/manager/qnaList")
    public String qnaList() {

        return "member/manager/qnaList";
    }


}
