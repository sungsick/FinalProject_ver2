package com.kh.myproject.member.manager.service;

import com.kh.myproject.member.manager.repository.QnaRepositoryM;
import com.kh.myproject.member.user.model.entity.Qna;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class QnaServiceM {

    @Autowired
    private QnaRepositoryM qnaRepositoryM;

    public List<Qna> getAllQna(){

        return qnaRepositoryM.findAll();
    }

    public void deleteQna(String qnaNumber){

        qnaRepositoryM.deleteById(Long.parseLong(qnaNumber));
    }

    public void updateAnswer(String qnaNumber, String qnaAnswer){
        qnaRepositoryM.updateAnswer(Long.parseLong(qnaNumber), qnaAnswer);
    }

}
