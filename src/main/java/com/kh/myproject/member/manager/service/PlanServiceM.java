package com.kh.myproject.member.manager.service;

import com.kh.myproject.community.plan.model.dto.PlanBoardDTO;
import com.kh.myproject.community.plan.model.entity.PlanBoard;
import com.kh.myproject.member.manager.repository.PlanDetailRepositoryM;
import com.kh.myproject.member.manager.repository.PlanRepositoryM;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PlanServiceM {

    @Autowired
    PlanRepositoryM planRepositoryM;

    @Autowired
    PlanDetailRepositoryM planDetailRepositoryM;


    public List<PlanBoardDTO> findAllByOrderByPbNumAsc() {


        List<PlanBoardDTO> result = new ArrayList<>();

        List<PlanBoard> list = planRepositoryM.findAllByOrderByPbNumAsc();

        for(int i = 0; i < list.size(); i++){
            PlanBoardDTO boardDTO = list.get(i).toDto();
            result.add(boardDTO);
        }
        return result;
    }
    public void deleteByUserUserNumber(Long userNumber){

        planRepositoryM.deleteByUserUserNumber(userNumber);
    }

    public List<PlanBoard> getPlanBoardListByUserNumber(Long userNumber){

        List<PlanBoard> planBoardList = planRepositoryM.findByUserUserNumber(userNumber);
        return planBoardList;
    }

    public void deletePlan(Long pbNum){

        planRepositoryM.deleteById(pbNum);
    }



    public void deletePlanDetailBoard(List<PlanBoard> planBoardList){

        for(int i = 0 ; i < planBoardList.size() ; i++){

            Long pbNum = planBoardList.get(i).getPbNum();
            planDetailRepositoryM.deleteByPlanBoardPbNum(pbNum);

        }
    }
}
