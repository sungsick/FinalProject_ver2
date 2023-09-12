package com.kh.myproject.member.manager.repository;

import com.kh.myproject.community.accompany.entity.Accompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;

public interface AccompanyRepositoryM extends JpaRepository<Accompany,Long> {


    @Modifying
    @Transactional
    void deleteAccompanyByUserUserNumber(Long userNumber);
}
