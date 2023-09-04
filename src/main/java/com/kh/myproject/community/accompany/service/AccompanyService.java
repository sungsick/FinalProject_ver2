package com.kh.myproject.community.accompany.service;


import com.kh.myproject.community.accompany.repository.AccompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccompanyService {


    @Autowired
    AccompanyRepository accompanyRepository;

    public void deleteByUserNumber(Long user_number){

        accompanyRepository.deleteByUserNumber(user_number);
    }
}
