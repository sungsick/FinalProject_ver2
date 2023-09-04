package com.kh.myproject.community.accompany.entity;

import com.kh.myproject.member.user.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "accompany")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Accompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ac_num")
    private Long ac_num;

    @Column
    private Long user_number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_number", referencedColumnName = "user_number", insertable = false, updatable = false)
    private User user;

    @Column
    private String ac_regdate; //작성일자

    @Column
    private String ac_title; //글 제목

    @Column
    private String ac_text; //글 내용t

    @Column
    private String ac_people; //동행자 수

    @Column
    private String ac_region; //동행 지역


    @Column
    private String ac_startdate; //시작 날짜

    @Column
    private String ac_enddate; //종료 날짜

    @Column
    private String ac_status; //모집 상태

    @Column
    private String ac_picture; //사진

    @Column
    private int ac_viewcount; // 조회수

    @Column
    private String ac_travelstyle; //여행취향

    @Column
    private String ac_personalhash; // 해쉬 태그
}