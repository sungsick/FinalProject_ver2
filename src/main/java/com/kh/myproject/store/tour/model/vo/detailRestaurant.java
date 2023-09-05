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
public class detailRestaurant {

    private String chkCreditCardFood;
    private String discountInfoFood;
    private String firstMenu;
    private String infoCenterFood;
    private String kidsFacility;
    private String openDateFood;
    private String openTimeFood;
    private String packing;
    private String parkingFood;
    private String reservationFood;
    private String restDateFood;
    private String scaleFood;
    private String seat;
    private String smoking;
    private String treatMenu;
    private String lcnsNo;
}
