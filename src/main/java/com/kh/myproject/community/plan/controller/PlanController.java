package com.kh.myproject.community.plan.controller;


import com.kh.myproject.community.plan.model.dto.PlanBoardDTO;
import com.kh.myproject.community.plan.model.dto.PlanBoardDetailDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static java.lang.Integer.parseInt;

@Controller
//@RestController
@SessionAttributes("user")
public class PlanController {


    private Map<Integer, ArrayList<PlanBoardDetailDTO>> planMap = new HashMap<>();

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

        System.out.println(planMap);
        int maxDay = 0;
        if (!planMap.isEmpty()) {
            model.addAttribute("planMap", planMap);
            for (int day : planMap.keySet()) {
                if (day > maxDay) {
                    maxDay = day;
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

        ArrayList<PlanBoardDetailDTO> planList = new ArrayList<>();

        for (PlanBoardDetailDTO PlanBoardDetailDTO : dtoList) {
            planList.add(PlanBoardDetailDTO);
        }
        planMap.put(dtoList[0].getPbdDate(), planList);


    }

    //일정 삭제하는 컨트롤러(Plan_write에서 삭제버튼 클릭 시)
    @PostMapping("/community/plan/deletePlan")
    @ResponseBody
    public void deletePlan(@RequestParam("day") String day, @RequestParam("placeName") String placeName){

        ArrayList<PlanBoardDetailDTO> temp = planMap.get(parseInt(day));
        for(int i = 0; i< temp.size(); i++ ){
            System.out.println(temp.get(i));
            if(temp.get(i).getPbdPlaceName().equals(placeName)){
                temp.remove(i);
            }
        }
        planMap.put(parseInt(day) , temp);
    }


    //Plan_write 작성 완료 버튼 클릭 시
    @Getter
    @Setter
    public class CombinedData {
        private PlanBoardDTO planBoardDTO;
        private PlanBoardDetailDTO planBoardDetailDTO;



        // Getter 및 Setter 메서드
    }
    @PostMapping("/community/plan/completePlan")
    public String completePlan(@RequestBody CombinedData combinedData) {
        // JSON 데이터를 CombinedData 객체로 자동으로 파싱하고 처리
        PlanBoardDTO planBoardDTO = combinedData.getPlanBoardDTO();
        PlanBoardDetailDTO planBoardDetailDTO = combinedData.getPlanBoardDetailDTO();
        // 여기에서 planBoardDTO와 planBoardDetailDTO를 사용하여 원하는 처리 수행

        return "community/plan/plan";
    }




}
