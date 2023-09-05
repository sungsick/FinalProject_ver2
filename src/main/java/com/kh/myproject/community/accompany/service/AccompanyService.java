package com.kh.myproject.community.accompany.service;

import com.kh.myproject.community.accompany.entity.Accompany;
import com.kh.myproject.community.accompany.repository.AccompanyRepository;
import com.kh.myproject.member.user.repository.UserRepository;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AccompanyService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccompanyRepository accompanyRepository;

    public Accompany updateAccompany(Accompany accompany){

        System.out.print("수정 전에 가져온 accompany 값" + accompany);


        accompanyRepository.updateAccompany(accompany);
        // save는 덮어씌우기 때문에 직접 query문을 실행한다..



        Accompany result = accompanyRepository.findById(accompany.getAc_num()).orElse(null);
        System.out.println("수정 후 가져온 result 값" + result);

        return result;

    }


}