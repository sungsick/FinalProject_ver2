package com.kh.myproject.store.tour.model.dto;

import com.kh.myproject.store.tour.model.entity.Tourism;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TourismDto {

    private Long areaId;
    private String areaName;
    private String areaNameKo;
    private int placeId;
    private String placeName;

    public Tourism toEntity(){
        return Tourism.builder()
                .areaId(areaId)
                .areaName(areaName)
                .areaNameKo(areaNameKo)
                .placeId(placeId)
                .placeName(placeName)
                .build();
    }
}
