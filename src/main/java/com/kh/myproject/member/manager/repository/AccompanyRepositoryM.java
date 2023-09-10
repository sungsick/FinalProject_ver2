package com.kh.myproject.member.manager.repository;

import com.kh.myproject.community.accompany.entity.Accompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface AccompanyRepositoryM extends JpaRepository<Accompany,Long> {

}
