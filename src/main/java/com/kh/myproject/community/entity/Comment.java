package com.kh.myproject.community.entity;

import com.kh.myproject.member.user.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long co_number; // 댓글번호


    @JoinColumn(name = "user_number")   //  외래 키 연결
    private int user_number; // 게시글작성자
    @Column
    private String co_content;    // 댓글내용
    @Column
    private String co_regdate;    //  댓글작성일자

    @ManyToOne
    @JoinColumn(name = "ac_num")
    private Accompany ac_num;  // 게시글번호




}
