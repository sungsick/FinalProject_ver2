package com.kh.myproject.community.plan.controller;


import com.kh.myproject.community.plan.model.dto.PlanDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
//@RestController
@SessionAttributes("user")
public class PlanController {


    private Map<Integer, List<PlanDTO>> planMap = new HashMap<>();
    //일정 리스트(일정 메인)
    @GetMapping("/community/plan") // http://localhost:8080/community/plan
    public String communityplan() {

          return "community/plan/plan";

    }

    //일정 글 정보
    @GetMapping("/community/plan/detail") // http://localhost:8080/community/plan/detail
    public String communityplandetail() {

        //int result = service.save(entity);
        /*
        if (result == 1){

        planList.clear();
        }

         */

        return "community/plan/plan_detail";
    }

    //일정 글 쓰기
    @GetMapping("/community/plan/write") // http://localhost:8080/community/plan/write
    public String communityplanwrite(Model model) {

        System.out.println(planMap);
        if(!planMap.isEmpty()) {
            model.addAttribute("planMap", planMap);
        }
        return "community/plan/plan_write";
        //return "communtity/plan/plan_write";
    }

    //일정 글쓰기 - 장소추가
    @GetMapping("/community/plan/add") // http://localhost:8080/community/plan/add
    public String communityplanadd(@RequestParam("day") int day,
                                   Model model) {
        model.addAttribute("day", day);

        return "community/plan/plan_add";
    }


    //일정 글쓰기 - 장소추가(Plan_add)에서 일정 글 쓰기(Plan_write)로 값을 보낼때 중간에 거치는 컨트롤러
    @PostMapping("/community/plan/move")
    @ResponseBody
    public void move(@RequestBody PlanDTO[] dtoList){

        List<PlanDTO> planList = new ArrayList<>();

        for (PlanDTO planDTO : dtoList) {
            planList.add(planDTO);
        }
        planMap.put(dtoList[0].getDay(), planList);



    }




}
