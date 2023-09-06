package com.kh.myproject.community.accompany.entity;

import com.kh.myproject.member.user.model.entity.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long co_number; // 댓글번호

    @ManyToOne()
    @JoinColumn(name = "userNumber")   //  외래 키 연결
    private User user; // 게시글작성자


    @ManyToOne
    @JoinColumn(name = "ac_num")
    private Accompany ac_num;  // 게시글번호

    @Column
    private String co_content;    // 댓글내용
    @Column
    private String co_regdate;    //  댓글작성일자







}