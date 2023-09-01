package com.kh.myproject.member.user.controller;


import com.kh.myproject.member.user.model.entity.Manager;
import com.kh.myproject.member.user.model.entity.Qna;
import com.kh.myproject.member.user.model.entity.User;
import com.kh.myproject.member.user.service.QnaService;
import com.kh.myproject.member.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("manager")
public class ManagerController {


    @Autowired
    UserService userService;

    @Autowired
    QnaService qnaService;


    // 매니저 뷰페이지는 크게 N가지로 나눈다.
    // 처음 메인 페이지를 보여주고
    // 그다음 여러개의 관리 페이지를 둔다.
    // 일정 게시글, 동행 , 렌트카 예약내역, 항공권 예약내역, 문의글 (답변 가능해야함)
    @GetMapping("/manager/user")
    public ModelAndView managerUser(
            @ModelAttribute("check_manager") Manager check_manager,
            ModelAndView modelAndView,
            HttpSession session) {

        System.out.println(check_manager);


        if (check_manager.getManagerId() != null || session.getAttribute("manager") != null) {
            //세션값이 있거나 userCOntroller에서 로그인 요청이 들어왔다면


            modelAndView.setViewName("/member/manager/user");
            List<User> userList = userService.findAllUser();

            modelAndView.addObject("manager", check_manager);
            modelAndView.addObject("userList", userList);

            // 렌트카 테이블에서 상위 예약정보 몇개를 빼온다.
            // 항공편 테이블에서 상위 예약정보 몇개를 빼온다.
            // 게시글 목록에서 각 카ㅌ고리별 상위 게시글 1개씩 빼온다.

        } else {

            // url로 접속했을 경우 에러페이지로 이동시킨다.
            modelAndView.setViewName("redirect:/errorPage");

        }

        return modelAndView;
    }


    @GetMapping("/manager/logout")
    public String flightList(SessionStatus sessionStatus) {

        sessionStatus.setComplete(); // 매니저 세션을 죽인다.

        return "redirect:/";
    }


    // 일정게시글 관리
    @GetMapping("/manager/plan")
    public String plan() {

        return "member/manager/plan";
    }

    // 동행게시글 관리
    @GetMapping("/manager/accompany")
    public String accompany() {

        return "member/manager/accompany";
    }


    @GetMapping("/manager/rentcar")
    public String rentcar() {

        return "member/manager/rentcar";
    }


    @GetMapping("/manager/flight")
    public String flight() {


        return "member/manager/flight";
    }


    // 문의글 가져오기
    @GetMapping("/manager/qna")
    public String qnaList(Model model) {

        List<Qna> qnaList = qnaService.getAllQna();
        model.addAttribute("qnaList", qnaList);

        return "member/manager/qna";
    }

    @PostMapping("/test/getUserChart")
    @ResponseBody
    public Map<String, Object> getUserChart(){

        List<Integer> countList = userService.getUserJoinCount();
        List<Object[]> list = userService.getUserAgeCount();
        Map<String,BigInteger> ageMap = new HashMap<>();


        System.out.println(list);
        for(int i = 0 ; i < list.size() ; i ++){

            for(int j = 0 ; j < list.get(i).length / 2 ; j++){

                ageMap.put((String)list.get(i)[j*2],(BigInteger)list.get(i)[j*2+1]);

            }
        }


        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("countList",countList);
        resultMap.put("ageMap",ageMap);

        return resultMap;
    }


    @GetMapping("/chart")
    public String chart(){


        return "member/manager/chart";
    }

    @ResponseBody
    @PostMapping("/manager/deleteUser")
    public List<User> deleteUser(@ModelAttribute(name = "user_number")
                             String user_number){


        System.out.println(user_number);
        userService.deleteUser(user_number);

        // 외래키로 설정한 테이블의 모든 데이터를 지운다.
        List<User> userList = userService.findAllUser();


        System.out.println(userList);

        return userList;

    }


}




