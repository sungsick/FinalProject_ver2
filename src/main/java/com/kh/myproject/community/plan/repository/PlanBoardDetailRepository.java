package com.kh.myproject.community.plan.repository;

import com.kh.myproject.community.plan.model.entity.PlanBoardDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanBoardDetailRepository extends JpaRepository<PlanBoardDetail, Long> {
    // 필요한 경우 사용자 정의 쿼리 메서드를 여기에 정의할 수 있습니다.
}
