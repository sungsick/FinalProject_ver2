package com.kh.myproject.community.plan.controller;


import com.kh.myproject.community.plan.model.dto.PlanBoardDTO;
import com.kh.myproject.community.plan.model.dto.PlanBoardDetailDTO;
import com.kh.myproject.community.plan.model.entity.PlanBoard;
import com.kh.myproject.community.plan.model.entity.PlanBoardDetail;
import com.kh.myproject.community.plan.repository.PlanBoardDetailRepository;
import com.kh.myproject.community.plan.repository.PlanBoardRepository;
import com.kh.myproject.community.plan.service.PlanBoardService;
import com.kh.myproject.member.user.model.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static java.lang.Integer.parseInt;

@Controller
//@RestController
@SessionAttributes("user")
public class PlanController {


    @Autowired
    PlanBoardService planBoardService;

//    private Map<Integer, ArrayList<PlanBoardDetailDTO>> planMap = new HashMap<>();
    private List<PlanBoardDetailDTO> planList = new ArrayList<>();

    //일정 리스트(일정 메인)
    @GetMapping("/community/plan") // http://localhost:8080/community/plan
    public String communityplan(Model model) {

        // 1. 서비스한테 게시글 목록 요청

        List<PlanBoardDTO> planList = planBoardService.getAllPlanBoardList();
        model.addAttribute("planList", planList);
        System.out.println(planList);



        List<PlanBoardDetailDTO> planDetailList = planBoardService.getAllPlanBoardDetailList();
        model.addAttribute("planDetailList", planDetailList);
        System.out.println(planDetailList);

        // 2.


        return "community/plan/plan";
    }

    //일정 글 정보
    @GetMapping("/community/plan/detail") // http://localhost:8080/community/plan/detail
    public String communityplandetail() {

        return "community/plan/plan_detail";
    }

    //일정 글 쓰기
    @GetMapping("/community/plan/write") // http://localhost:8080/community/plan/write
    public String communityplanwrite(Model model, @ModelAttribute("user")User user) {

        model.addAttribute(user);

        System.out.println(planList);
        int maxDay = 0;
        if (!planList.isEmpty()) {
            model.addAttribute("planList", planList);
            for(int i = 0; i < planList.size(); i++){
                if(planList.get(i).getPbdDate() > maxDay){
                    maxDay = planList.get(i).getPbdDate();
                }
            }
            model.addAttribute("maxDay", maxDay);
        }

        System.out.println("maxDay = " + maxDay);
        return "community/plan/plan_write";

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
    public void move(@RequestBody PlanBoardDetailDTO[] dtoList) {


        for (PlanBoardDetailDTO PlanBoardDetailDTO : dtoList) {
            planList.add(PlanBoardDetailDTO);
        }


    }

    //일정 삭제하는 컨트롤러(Plan_write에서 삭제버튼 클릭 시)
    @PostMapping("/community/plan/deletePlan")
    @ResponseBody
    public void deletePlan(@RequestParam("day") String day, @RequestParam("placeName") String placeName){

        for(int i = 0; i< planList.size(); i++ ){

            if(planList.get(i).getPbdPlaceName().equals(placeName) && planList.get(i).getPbdDate() == parseInt(day)){
                planList.remove(i);
            }
        }
    }


    //Plan_write 작성 완료 버튼 클릭 시
    @PostMapping("/community/plan/completePlan")
    @ResponseBody
    public String completePlan(@RequestBody PlanBoardDTO boardDTO,
                               @ModelAttribute("user") User user) {



        // 1. Dto user 정보 저장
        boardDTO.setUser(user);

        // 2. service에서 db에 저장할때 필요한거 다 넘겨줌
        planBoardService.savePlanBoard(boardDTO, planList);

        // 9. 저장이 완료되면 planList 초기화
        planList.clear();

        return "community/plan/plan";
    }






}








