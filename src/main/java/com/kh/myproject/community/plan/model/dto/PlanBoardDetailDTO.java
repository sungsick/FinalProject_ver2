package com.kh.myproject.community.plan.model.dto;

import com.kh.myproject.community.plan.model.entity.PlanBoard;
import com.kh.myproject.community.plan.model.entity.PlanBoardDetail;
import lombok.*;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class PlanBoardDetailDTO {
    private Long pbdNum;
    private String pbdPlaceName;
    private String pbdCategoryGroupName;
    private double pbdX;
    private double pbdY;
    private int pbdDate;
    private PlanBoard planBoard;

    public PlanBoardDetail toEntity(){
        return PlanBoardDetail.builder()
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
