package com.kh.myproject.member.manager.service;


import com.kh.myproject.community.accompany.entity.Accompany;
import com.kh.myproject.member.manager.repository.AccompanyRepositoryM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

@Service
public class AccompanyServiceM {


    @Autowired
    AccompanyRepositoryM accompanyRepository;

    public void deleteByUserNumber(String userNumber){

        accompanyRepository.deleteById(Long.parseLong(userNumber));
    }

    public List<Accompany> findAll(){

        return accompanyRepository.findAll();
    }

}
