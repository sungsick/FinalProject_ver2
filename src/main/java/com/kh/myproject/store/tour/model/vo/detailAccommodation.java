package com.kh.myproject.store.tour.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.LowerCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class detailAccommodation {

    private String acComCountLodging;
    private String benikia;
    private String checkInTime;
    private String checkOutTime;
    private String chkCooking;
    private String foodPlace;
    private String goodStay;
    private String hanok;
    private String infoCenterLodging;
    private String parkingLodging;
    private String pickup;
    private String roomCount;
    private String reservationLodging;
    private String reservationUrl;
    private String roomType;
    private String scaleLodging;
    private String subFacility;
    private String barbecue;
    private String beauty;
    private String beverage;
    private String bicycle;
    private String campfire;
    private String fitness;
    private String karaoke;
    private String publicBath;
    private String publicPc;
    private String sauna;
    private String seminar;
    private String sports;
    private String refundRegulation;
}
