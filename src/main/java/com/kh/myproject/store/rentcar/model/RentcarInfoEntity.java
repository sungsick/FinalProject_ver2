package com.kh.myproject.store.rentcar.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name="car_info")
public class RentcarInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carInfo_id;

    @Column
    private String car_name;
    @Column
    private String car_nation;
    @Column
    private String car_type;
    @Column
    private String oil_type;
    @Column
    private String driver_age;
    @Column
    private int car_people;
    @Column
    private int car_price;
    @Column
    private int car_discount;
    @Column
    private int com_id;
    @Column
    private String car_option;
    @Column
    private String car_img;


    public RentcarInfoDTO toDTO() {

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
