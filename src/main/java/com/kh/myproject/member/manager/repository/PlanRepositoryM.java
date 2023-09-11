package com.kh.myproject.member.manager.repository;

import com.kh.myproject.community.plan.model.entity.PlanBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanRepositoryM extends JpaRepository<PlanBoard, Long> {
    List<PlanBoard> findAllByOrderByPbNumAsc();

    List<PlanBoard> findByUserUserNumber(Long userNumber);
}
