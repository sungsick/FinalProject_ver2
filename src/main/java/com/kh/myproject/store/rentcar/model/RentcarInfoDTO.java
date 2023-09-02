package com.kh.myproject.store.rentcar.model;


import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentcarInfoDTO {


    private Long carInfo_id;
    private String car_name;
    private String car_nation;
    private String car_type;
    private String oil_type;
    private String driver_age;
    private int car_people;
    private int car_price;
    private int car_discount;
    private int com_id;
    private String car_option;




}
