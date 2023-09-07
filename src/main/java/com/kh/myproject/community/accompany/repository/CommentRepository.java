package com.kh.myproject.community.accompany.repository;

import com.kh.myproject.community.accompany.entity.Comment;
import com.kh.myproject.member.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByUser(User user);

    @Query("SELECT co FROM Comment co WHERE co.co_content LIKE %:searchName% ORDER BY co.co_regdate")
    List<Comment> findByCo_contentOrOrderByCo_regdate(@Param("searchName") String searchName);


    @Query("select co from Comment co join Accompany ac on ac.ac_num = co.accompany.ac_num where co.accompany.ac_num = :ac_num")
    List<Comment> findAllByAccompany_Acnum(Long ac_num);
}
