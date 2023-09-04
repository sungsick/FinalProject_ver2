package com.kh.myproject.community.plan.model.entity;

import com.kh.myproject.community.plan.model.dto.PlanBoardDTO;
import com.kh.myproject.member.user.model.entity.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="plan_board")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PlanBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pbNum; //게시글번호

    @CreationTimestamp
    @Column
    private LocalDateTime pbWriteDate; // 작성일자

    @Column
    private String pbTitle; //글제목

    @Column
    private  String pbStartDate; //떠나는날

    @Column
    private  String pbEndDate;  //돌아오는날

    @Column
    private  String pbRegion; //여행지역

    @Column
    private int pbViewCount;  //조회수

    @ManyToOne()
    @JoinColumn(name = "userNumber")
    private User user;  //유저번호


    public PlanBoardDTO toDto(){
        return PlanBoardDTO.builder()
                .pbNum(pbNum)
                .pbWriteDate(pbWriteDate)
                .pbTitle(pbTitle)
                .pbStartDate(pbStartDate)
                .pbEndDate(pbEndDate)
                .pbRegion(pbRegion)
                .pbViewCount(pbViewCount)
                .user(user)
                .build();
    }



}
