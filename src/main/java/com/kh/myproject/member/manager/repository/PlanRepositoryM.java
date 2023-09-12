package com.kh.myproject.member.manager.repository;

import com.kh.myproject.community.plan.model.entity.PlanBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.List;

public interface PlanRepositoryM extends JpaRepository<PlanBoard, Long> {
    List<PlanBoard> findAllByOrderByPbNumAsc();

    List<PlanBoard> findByUserUserNumber(Long userNumber);

    @Modifying
    @Transactional
    void deleteByUserUserNumber(Long userNumber);


}
