package com.kh.myproject.community.accompany.repository;

import com.kh.myproject.community.accompany.entity.Accompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccompanyRepository extends JpaRepository <Accompany, Long>{

    @Query("SELECT ac FROM Accompany  ac WHERE ac.ac_num = :ac_num")

    Accompany findByAcnum(@Param("ac_num") Long ac_num);






}
