package com.kh.myproject.community.accompany.repository;

import com.kh.myproject.community.accompany.entity.Comment;
import com.kh.myproject.member.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByUser(User user);


}
