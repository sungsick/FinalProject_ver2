package com.kh.myproject.store.rentcar.service;


import com.kh.myproject.store.rentcar.model.RentcarInfoDTO;
import com.kh.myproject.store.rentcar.repository.RentcarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentcarService {

    @Autowired
    private static RentcarRepository rentcarRepository;

    public static List<RentcarInfoDTO> searchKeyword(String searchKeyword){

        return rentcarRepository.findbycar_name(searchKeyword);
    }




}
