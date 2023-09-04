package com.kh.myproject.community.accompany.dto;

import com.kh.myproject.community.accompany.entity.Accompany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccompanyForm {

    private Long ac_num; //게시글번호
    private Long user_number; //유저아이디
    private String ac_regdate; //작성일자
    private String ac_title; //글 제목
    private String ac_text; //글 내용
    private String ac_people; //동행자 수
    private String ac_region; //동행 지역
    private String ac_startdate; //시작 날짜
    private String ac_enddate; //종료 날짜
    private String ac_status; //모집 상태
    private String ac_picture; //사진
    private int ac_viewcount; // 조회수
    private String ac_travelstyle; //여행취향
    private String ac_personalhash; // 해쉬 태그

    public Accompany toEntity() {
        return Accompany.builder()
                .ac_num(ac_num)
                .user_number(user_number)
                .ac_regdate(ac_regdate)
                .ac_title(ac_title)
                .ac_text(ac_text)
                .ac_people(ac_people)
                .ac_region(ac_region)
                .ac_startdate(ac_startdate)
                .ac_enddate(ac_enddate)
                .ac_status(ac_status)
                .ac_picture(ac_picture)
                .ac_viewcount(ac_viewcount)
                .ac_travelstyle(ac_travelstyle)
                .ac_personalhash(ac_personalhash)
                .build();
    }

}
