package com.kh.myproject.member.manager.service;


import com.kh.myproject.community.accompany.entity.Accompany;
import com.kh.myproject.member.manager.repository.AccompanyRepositoryM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccompanyServiceM {


    @Autowired
    AccompanyRepositoryM accompanyRepository;

    public void deleteByUserNumber(Long userNumber){

        accompanyRepository.deleteById(userNumber);
    }

    public List<Accompany> findAll(){

        return accompanyRepository.findAll();
    }

}
