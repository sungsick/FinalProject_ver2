package com.kh.myproject.community.accompany.repository;

import com.kh.myproject.community.accompany.entity.Accompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface AccompanyRepository extends JpaRepository<Accompany,Long> {



    @Query("delete from Accompany a where a.user.userNumber = :user_number")
    @Modifying
    @Transactional
    void deleteByUserNumber(Long user_number);
}
