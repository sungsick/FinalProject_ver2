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
    private String car_img;


    public RentcarInfoDTO toEntity() {

        return RentcarInfoDTO.builder()
                .carInfo_id(carInfo_id)
                .car_name(car_name)
                .car_nation(car_nation)
                .car_type(car_type)
                .driver_age(driver_age)
                .car_people(car_people)
                .car_price(car_price)
                .car_discount(car_discount)
                .com_id(com_id)
                .car_option(car_option)
                .car_img(car_img)
                .build();

    }




}
