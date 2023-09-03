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
import java.util.List;

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

            modelAndView.setViewName("member/manager/user");
            List<User> userList = userService.getSomeUser();

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

    @GetMapping("/manager/manageUser")
    public String userList(Model model) {

        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);


        return "member/manager/manageUser";
    }

    @GetMapping("/manager/qna")
    public ModelAndView qna(
            @ModelAttribute("check_manager") Manager check_manager,
            ModelAndView modelAndView,
            HttpSession session) {

        if (check_manager.getManagerId() != null || session.getAttribute("manager") != null) {
            //세션값이 있거나 userCOntroller에서 로그인 요청이 들어왔다면

            modelAndView.setViewName("member/manager/qna");
            List<Qna> qnaList = qnaService.getAllQna();

            modelAndView.addObject("manager", check_manager);
            modelAndView.addObject("qnaList", qnaList);

            // 렌트카 테이블에서 상위 예약정보 몇개를 빼온다.
            // 항공편 테이블에서 상위 예약정보 몇개를 빼온다.
            // 게시글 목록에서 각 카ㅌ고리별 상위 게시글 1개씩 빼온다.

        } else {

            // url로 접속했을 경우 에러페이지로 이동시킨다.
            modelAndView.setViewName("redirect:/errorPage");

        }

        return modelAndView;
    }


    @GetMapping("/manager/manageReservation")
    public String flightList() {

        return "member/manager/manageReservation";
    }


    @GetMapping("/manager/manageUserInfo")
    public String flightList(@RequestParam("userNumber") Long userNumber) {

        System.out.println(userNumber);

        return "member/manager/manageUserInfo";
    }


    @GetMapping("/manager/logout")
    public String flightList(SessionStatus sessionStatus) {

        sessionStatus.setComplete(); // 매니저 세션을 죽인다.

        return "redirect:/";
    }

    @ResponseBody
    @PostMapping("/manager/deleteQna")
    public List<Qna> deleteQna(@ModelAttribute(name = "qnaNumber")
                               String qnaNumber) {

        System.out.println(qnaNumber);
        qnaService.deleteQna(qnaNumber);

        // 외래키로 설정한 테이블의 모든 데이터를 지운다.
        List<Qna> qnaList = qnaService.getAllQna();


        System.out.println(qnaList);

        return qnaList;
    }

    @ResponseBody
    @PostMapping("/manager/answerQna")
    public void answerQna(@RequestParam("qnaNumber") String qnaNumber,
                          @RequestParam("qnaAnswer") String qnaAnswer)  {

        System.out.println(qnaNumber);
        System.out.println(qnaAnswer);

        qnaService.updateAnswer(qnaNumber, qnaAnswer);

    }

//    @GetMapping("/manager/rentcarList")
//    public String rentcarList() {
//
//        return "managerRentcar";
//    }
//
//    @GetMapping("/manager/qnaList")
//    public String qnaList() {
//
//        return "manageBoard";
//    }


}
