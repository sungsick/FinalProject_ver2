package com.kh.myproject.community.plan.model.entity;

import com.kh.myproject.community.plan.model.dto.PlanBoardDetailDTO;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="plan_board_detail")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PlanBoardDetail {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pbdNum; //세부일정번호

    @Column
    private String pbdPlaceName; //여행지명


    @Column
    private String pbdCategoryGroupName; //장소분류명

    @Column
    private double pbdX; //x좌표

    @Column
    private double pbdY; //y좌표

    @Column
    private int pbdDate;

    @ManyToOne()
    @JoinColumn(name ="pbNum")
    private PlanBoard planBoard; //pbNum

    public PlanBoardDetailDTO toDto(){
        return PlanBoardDetailDTO.builder()
                .pbdNum(pbdNum)
                .pbdPlaceName(pbdPlaceName)
                .pbdCategoryGroupName(pbdCategoryGroupName)
                .pbdX(pbdX)
                .pbdY(pbdY)
                .planBoard(planBoard)
                .pbdDate(pbdDate)
                .build();
    }


}
