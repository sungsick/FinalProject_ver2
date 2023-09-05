package com.kh.myproject.member.manager.repository;

import com.kh.myproject.member.user.model.entity.Qna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface QnaRepositoryM extends JpaRepository<Qna, Long> {
    @Modifying
    @Transactional
    @Query("update Qna q" +
            " set q.qnaAnswer = :qna_answer" +
            " where q.qnaNumber = :qna_number")
    void updateAnswer(@Param("qna_number")Long qnaNumber,
                      @Param("qna_answer")String qnaAnswer);
}
