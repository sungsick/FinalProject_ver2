package com.kh.myproject.community.plan.service;

import com.kh.myproject.community.plan.model.dto.PlanBoardDTO;
import com.kh.myproject.community.plan.model.dto.PlanBoardDetailDTO;
import com.kh.myproject.community.plan.model.entity.PlanBoard;
import com.kh.myproject.community.plan.model.entity.PlanBoardDetail;
import com.kh.myproject.community.plan.repository.PlanBoardDetailRepository;
import com.kh.myproject.community.plan.repository.PlanBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PlanBoardService {


    @Autowired
    private PlanBoardRepository planBoardRepository;

    @Autowired
    private PlanBoardDetailRepository detailRepository;

    // 3. Controller에서 넘겨준 boardDTO, planList 받아줌
    public void savePlanBoard(PlanBoardDTO boardDTO,
                              List<PlanBoardDetailDTO> planList) {

        // 4. db에 저장하기 위해 boardDTo를 엔티티로 변환
        PlanBoard planBoard = boardDTO.toEntity();

        for (int i = 0; i < planList.size(); i++) {

            // 5. list[i]에 있는 dto객체를 detailDTO에 저장
            PlanBoardDetailDTO detailDTO = planList.get(i);

            // 6. 일정이 어느게시글인지를 저장
            detailDTO.setPlanBoard(planBoard);

            // 7. 일정DTO를 db에 저장하기 위해 엔티티로 변환
            PlanBoardDetail detail = detailDTO.toEntity();

            // 8. 일정하나를 db에 저장 => 5번 부터 다시(List에 size만큼 반복)
            detailRepository.save(detail);
        }

    }


    // DB에서 데이터 가져와서 Plan_main에 출력
    public List<PlanBoardDTO> getAllPlanBoardList() {

        List<PlanBoardDTO> result = new ArrayList<>();

        List<PlanBoard> list = planBoardRepository.findAll();

        for(int i = 0; i < list.size(); i++){
            PlanBoardDTO boardDTO = list.get(i).toDto();
            result.add(boardDTO);
        }
        return result;
    }

    public List<PlanBoardDetailDTO> getAllPlanBoardDetailList(){
        List<PlanBoardDetailDTO> result = new ArrayList<>();

        List<PlanBoardDetail> list = detailRepository.findAll();

        for(int i = 0; i < list.size(); i++){
            PlanBoardDetailDTO boardDetailDTO = list.get(i).toDto();
            result.add(boardDetailDTO);
        }

        return result;
    }


}
