package com.kh.myproject.community.accompany.controller;

import com.kh.myproject.community.dto.AccompanyForm;
import com.kh.myproject.community.entity.Accompany;
import com.kh.myproject.community.repository.AccompanyRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@SessionAttributes("user")
public class AccompanyController {

    @Autowired
    private AccompanyRepository accompanyRepository;

    //여행커뮤니티 홈(메인페이지 병합 전 삭제)
    @GetMapping("/community/home") //http://localhost:8070/community/home
    public List<Accompany> index() {

        System.out.println("donghangMain2 테스트..");

        return accompanyRepository.findAll();
    }



    //동행 리스트(동행 메인)
    @GetMapping("/community/accompany") // http://localhost:8070/community/accompany
    public String communityaccompany(Model model) {

        System.out.println("컨트롤러의 ");
        // 목록보기

        return "community/accompany/accompany";
    }


    //동행 글 쓰기
    @GetMapping ("/community/accompany/write") // http://localhost:8070/community/accompany/write
    public String communityaccompanywrite() {


        return "community/accompany/accompany_write";
        /*"community/accompany/accompany_write";*/

    }

    @GetMapping ("/community/accompany/writePro") // http://localhost:8070/community/accompany/write
    public String communityaccompanywritePro(AccompanyForm form,
                                             @RequestParam("ac_startdate")String ac_startdate,
                                             @RequestParam("ac_startdate")String ac_enddate,
                                             @RequestParam("ac_title")String ac_title,
                                             @RequestParam("ac_text")String ac_text,
                                             @RequestParam("ac_people")String ac_people,
                                             @RequestParam("ac_picture")String ac_picture
                                                ) {

        System.out.println(form);

        System.out.println("ac_startdate" + ac_startdate);
        System.out.println("ac_startdate" + ac_startdate);
        System.out.println("ac_title" + ac_title);
        System.out.println("ac_text" + ac_text);
        System.out.println("ac_people" + ac_people);
        System.out.println("ac_picture" + ac_picture);

        // DTO의 데이터를 Entity로 변환한다.
        Accompany accompany = form.toEntity();
        System.out.println(accompany);

        // Repository에게 Entity를 데이터베이스에 저장하게 한다
        // id 가 자동으로 증가된다.

        Accompany saved = accompanyRepository.save(accompany);
        System.out.println(saved);

        return "redirect:/community/accompany";
        /*"community/accompany/accompany_write";*/

    }

    //동행 글 정보
    @GetMapping("/community/accompany/detail") // http://localhost:8070/community/accompany/detail
    public String communityaccompanydetail() {


        return "community/accompany/accompany_detail";
    }


//    // 글 번호 가지고 수정하는 메서드
//    // 여행 친구 찾기 페이지, 값을 가져감
//    @GetMapping("/community/accompany/detail/{ac_num}/edit")
//    public String communityAccompanyEdit(@PathVariable Long ac_num, Model model, ){
//        System.out.println("컨트롤러의 edit() 메서드를 실행");
//        System.out.println("ac_num = " + ac_num);
//
//        //수정할 데이터를 얻어온다.
//
//        Accompany accompanyEntity = accompanyRepository.findById(ac_num).orElse(null);
//
//        //테이블에서 데이터를 가져와서 accompany_Detail파일로 넘기기 위해서
//        // model 인터페이스 객체에 넣어준다.
//
//        model.addAttribute("accompany", accompanyEntity);
//
//        return "community/accompany/accompany_write";
//
//
//    }


//    // 동행 글의 수정 클릭 > 해당 글 번호 불러오기
//    @GetMapping("/community/accompany/detail/{ac_num}/")
//    public Accompany index(@PathVariable Long ac_num) {
//        return accompanyRepository.findById(ac_num).orElse(null);
//    }
//
//
//
//    // 글 번호를 가지고 수정하는 메서드
//    @PostMapping("/community/accompany/updatePro")
//    public String communityAccompanyupdate(AccompanyForm form){
//        System.out.println("컨트롤러 update() 메서드 실행");
//        System.out.println(form.toString());
//
//        // DTO -> Entity 로 변환한다.
//        Accompany accompany = form.toEntity();
//        System.out.println(accompany.toString());
//
//        // 데이터베이스에 저장된 수정할 데이터를 얻어와서 Entity로 수정한 후
//        // 데이터베이스에 저장한다
//        Accompany target = accompanyRepository.findById(accompany.getAc_num()).orElse(null);
//
//        if(target != null){
//            accompanyRepository.save(accompany);
//        }
//
//        // 수정한 글 1건만 보여주고 싶을 때는
//        return "community/accompany/accompany_detail" + accompany.getAc_num();
//
//    }
//





//    //동행 글 정보
//    @GetMapping("/community/accompany/detail/{ac_num}") // http://localhost:8070/community/accompany
//    public String communityAccompanyDetail(@PathVariable Long ac_num, Model model){
//
//        System.out.println("컨트롤러의 show() 메서드 실행");
//        System.out.println("ac_num = " + ac_num);
//
//        // ac_num 한 건마다 해당되는 테이블에서 가지고 온다.
//        // findById() id 값을 넣어주면 테이블에서 찾아서 결과를 반환한다.
//        // 만약 데이터가 없다면 orElse(null) 메서드가 실행하면 null을 리턴시킨다.
//
//        Accompany accompanyEntity = accompanyRepository.findById(ac_num).orElse(null);
//
//        model.addAttribute("accompany", accompanyEntity);
//
//        return "community/accompany/accompany_detail";
//
//    }
//
//


//
//
//    // 글 삭제하기
//    @GetMapping("/community/accompany/accompany/{ac_num}/delete")
//    public String communityAccompanydelete(@PathVariable Long ac_num, RedirectAttributes rttr){
//
//        System.out.println("컨트롤러 delete() 메서드를 실행");
//        System.out.print("ac_num : " + ac_num);
//
//        // 삭제할 데이터를 가져온다.
//        Accompany target = accompanyRepository.findById(ac_num).orElse(null);
//        System.out.println(target.toString());
//
//        //데이터 삭제
//        if(target != null) {
//            accompanyRepository.delete(target);
//
//            rttr.addFlashAttribute("msg", ac_num + "번 글 삭제 완료!");
//        }
//
//        return "community/accompany/accompany";
//    }





}