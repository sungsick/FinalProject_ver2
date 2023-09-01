package com.kh.myproject.community.repository;

import com.kh.myproject.community.entity.Accompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccompanyRepository extends JpaRepository <Accompany, Long>{

}
