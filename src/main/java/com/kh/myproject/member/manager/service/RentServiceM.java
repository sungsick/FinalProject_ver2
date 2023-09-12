package com.kh.myproject.member.manager.service;

import com.kh.myproject.member.manager.repository.RentRepositoryM;
import com.kh.myproject.store.rentcar.model.entity.RentReservationInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RentServiceM {
    @Autowired
    private RentRepositoryM rentRepositoryM;

    public List<RentReservationInfo> getAllRent() {

        return rentRepositoryM.findAll();
    }
    public void deleteRent(Long userNumber){

        rentRepositoryM.deleteByUserUserNumber(userNumber);
    }
}
