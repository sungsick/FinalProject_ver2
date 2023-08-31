package com.kh.myproject.store.tour.model.entity;

import com.kh.myproject.store.tour.model.dto.AreaTourismDto;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
@Entity
@Table(name = "area_tourism")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class AreaTourism {

    @Id
    private String areaName;
    @Column
    private String areaNameKo;
    @Column
    private int placeId;
    @Column
    private String placeName;

    public AreaTourismDto toDto(){
        return AreaTourismDto.builder()
                .areaName(areaName)
                .areaNameKo(areaNameKo)
                .placeId(placeId)
                .placeName(placeName)
                .build();
    }


}
