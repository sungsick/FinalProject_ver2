package com.kh.myproject.community.plan.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RestController
@SessionAttributes("user")
public class PlanController {

    //일정 리스트(일정 메인)
    @GetMapping("/community/plan") // http://localhost:8080/community/plan
    public String communityplan() {

          return "community/plan/plan";

    }

    //일정 글 정보
    @GetMapping("/community/plan/detail") // http://localhost:8080/community/plan/detail
    public String communityplandetail() {


        return "community/plan/plan_detail";
    }

    //일정 글 쓰기
    @GetMapping("/community/plan/write") // http://localhost:8080/community/plan/write
    public String communityplanwrite() {


        return "community/plan/plan_write";
    }

    //일정 글쓰기 - 장소추가
    @GetMapping("/community/plan/add") // http://localhost:8080/community/plan/add
    public String communityplanadd() {


        return "community/plan/plan_add";
    }



/*
    @GetMapping("/community/plan/write/{item}") // http://localhost:8080/community/plan/write
    public String communityplanwrite2(@PathVariable Item item) {

        System.out.println(item);
        return "community/plan/plan_write";
    }

 */

//    @PostMapping("/community/plan/move")
//    public ModelAndView move(@RequestParam(value = "age")int age, ModelAndView mav){
//        mav.addObject("age",age);
//        System.out.println(age);
//        mav.setViewName("community/plan/plan_write");
//        return mav;
//    }











}
