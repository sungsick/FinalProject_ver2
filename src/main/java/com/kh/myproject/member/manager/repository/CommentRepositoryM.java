package com.kh.myproject.member.manager.repository;

import com.kh.myproject.community.accompany.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepositoryM extends JpaRepository<Comment, Long> {

    void deleteByUserUserNumber(Long userNumber);
}
