package com.kh.myproject.community.repository;

import com.kh.myproject.community.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository <Comment, Long>{



}
