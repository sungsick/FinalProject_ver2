package com.kh.myproject.store.rentcar.service;


import com.kh.myproject.store.rentcar.model.RentcarComDTO;
import com.kh.myproject.store.rentcar.model.RentcarComEntity;
import com.kh.myproject.store.rentcar.model.RentcarInfoDTO;
import com.kh.myproject.store.rentcar.model.RentcarInfoEntity;
import com.kh.myproject.store.rentcar.repository.RentcarComRepository;
import com.kh.myproject.store.rentcar.repository.RentcarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentcarService {

    @Autowired
    private RentcarRepository rentcarRepository;

    @Autowired
    private RentcarComRepository rentcarComRepository;

    public List<RentcarInfoDTO> searchKeyword(String searchKeyword){

        System.out.println("searchKeyword 서비스 메서드 실행");
        System.out.println(searchKeyword);

        List<RentcarInfoEntity> entities = rentcarRepository.FindByCar_name(searchKeyword);


        return entities.stream()
                .map(RentcarInfoDTO::fromEntity)
                .collect(Collectors.toList());
    }




//차량 전체 리스트 정렬
    public List<RentcarInfoDTO> findAll() {

        List<RentcarInfoEntity> entities = rentcarRepository.FindAll();

        return entities.stream()
                .map(RentcarInfoDTO::fromEntity)
                .collect(Collectors.toList());


    }

    //높은 가격순 정렬
    @Transactional
    public List<RentcarInfoDTO> FindDiscountDesc(List<RentcarInfoDTO> rentcarlist) {

        List<RentcarInfoEntity> entities = rentcarRepository.FindDiscountDesc();

        return entities.stream()
                .map(RentcarInfoDTO::fromEntity)
                .collect(Collectors.toList());


    }



    //낮은가격순 정렬
    @Transactional
    public List<RentcarInfoDTO> FindDiscountAsc(List<RentcarInfoDTO> rentcarlist) {

        List<RentcarInfoEntity> entities = rentcarRepository.FindDiscountAsc();

        return entities.stream()
                .map(RentcarInfoDTO::fromEntity)
                .collect(Collectors.toList());


    }

    //차종순 정렬
    @Transactional
    public List<RentcarInfoDTO> FindTypeAsc(List<RentcarInfoDTO> rentcarlist) {

        List<RentcarInfoEntity> entities = rentcarRepository.FindTypeAsc();

        return entities.stream()
                .map(RentcarInfoDTO::fromEntity)
                .collect(Collectors.toList());


    }



    // 렌터카 업체 선택
    public List<RentcarComDTO> getComSelect(String car_name){

        List<RentcarComEntity> entities = rentcarComRepository.FindByCar_name(car_name);

        return entities.stream()
                .map(RentcarComDTO::fromEntity)
                .collect(Collectors.toList());


    }


}
