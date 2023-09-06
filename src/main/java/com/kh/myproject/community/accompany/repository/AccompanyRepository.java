package com.kh.myproject.community.accompany.repository;

import com.kh.myproject.community.accompany.entity.Accompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface AccompanyRepository extends JpaRepository<Accompany,Long> {


    @Query("select a from Accompany a where a.ac_text LIKE :searchName OR a.ac_title LIKE :searchName ORDER BY a.ac_regdate DESC")
    List<Accompany> findByAc_textOrAc_titleOrderBOrderByAc_regdateDesc(@Param("searchName")String searchName);

    @Query("select max(a.ac_num) from Accompany a")
    int findTopByAc_num();


    @Transactional
    @Modifying
    @Query("update Accompany a set a.ac_viewcount = a.ac_viewcount+1 where a.ac_num = :ac_num")
    void increaseViewCount(@Param("ac_num")Long ac_num);
}
