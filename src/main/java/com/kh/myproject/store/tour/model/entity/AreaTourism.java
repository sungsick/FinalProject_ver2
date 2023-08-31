package com.kh.myproject.store.tour.model.entity;

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
public class AreaTourism {

    @Id
    private String areaName;
    @Column
    private String areaNameKo;
    @Column
    private int placeId;
    @Column
    private String placeName;


}
