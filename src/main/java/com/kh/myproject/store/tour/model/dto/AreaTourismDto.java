package com.kh.myproject.store.tour.model.dto;

import com.kh.myproject.store.tour.model.entity.AreaTourism;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AreaTourismDto {

    private String areaName;
    private String areaNameKo;
    private int placeId;
    private String placeName;

    public AreaTourism toEntity(){
        return AreaTourism.builder()
                .areaName(areaName)
                .areaNameKo(areaNameKo)
                .placeId(placeId)
                .placeName(placeName)
                .build();
    }
}
