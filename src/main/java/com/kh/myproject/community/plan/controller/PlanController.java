package com.kh.myproject.community.plan.controller;


import com.kh.myproject.community.plan.model.dto.PlanDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Controller
//@RestController
@SessionAttributes("user")
public class PlanController {


    private List<PlanDTO> planList = new ArrayList<PlanDTO>();
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
    public String communityplanwrite(Model model) {

        if(!planList.isEmpty()) {
            model.addAttribute("planList", planList);
        }
        return "community/plan/plan_write";
        //return "communtity/plan/plan_write";
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

    @PostMapping("/community/plan/move")
    @ResponseBody
    public void move(@RequestBody PlanDTO[] map){

        for (PlanDTO planDTO : map) {
            planList.add(planDTO);
            System.out.println(planList);
        }



    }











}
