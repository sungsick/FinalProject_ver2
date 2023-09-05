package com.kh.myproject.community.accompany.repository;

import com.kh.myproject.community.accompany.entity.Accompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AccompanyRepository extends JpaRepository <Accompany, Long>{

@Modifying
    @Transactional
    @Query(value = "update Accompany ac" +
    " set ac.ac_region = :#{#accompany.ac_region}," +
            " ac.ac_startdate = :#{#accompany.ac_startdate}," +
            " ac.ac_enddate = :#{#accompany.ac_enddate}," +
            " ac.ac_picture = :#{#accompany.ac_picture}," +
            " ac.ac_title = :#{#accompany.ac_title}," +
            " ac.ac_text = :#{#accompany.ac_text}," +
            " ac.ac_people = :#{#accompany.ac_people}" +
            " where ac.ac_num = :#{#accompany.ac_num}", nativeQuery = true)
void updateAccompany(@Param("accompany") Accompany accompany);


}
