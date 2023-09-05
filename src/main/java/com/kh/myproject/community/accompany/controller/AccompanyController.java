package com.kh.myproject.community.accompany.controller;

import com.kh.myproject.community.accompany.dto.AccompanyForm;
import com.kh.myproject.community.accompany.entity.Accompany;
import com.kh.myproject.community.accompany.repository.AccompanyRepository;

import com.kh.myproject.community.accompany.service.AccompanyService;
import com.kh.myproject.member.user.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes("user")
public class AccompanyController {

    @Autowired
    private AccompanyRepository accompanyRepository;

    @Autowired
    private AccompanyService accompanyService;

    //여행커뮤니티 홈(메인페이지 병합 전 삭제)
    @GetMapping("/community/home") //http://localhost:8070/community/home
    public List<Accompany> index() {

        System.out.println("donghangMain2 테스트..");

        return accompanyRepository.findAll();
    }


    //동행 리스트(동행 메인)
    @GetMapping("/community/accompany") // http://localhost:8070/community/accompany
    public String accompanyIndex(Model model) throws Exception {

        System.out.println("컨트롤러의 ");
        // 목록보기

        // db에서 정보를 가져오는 locig을 짜야함
        List<Accompany> accompanyEntity = accompanyRepository.findAll();
        Accompany ac = accompanyEntity.get(0);
        User acUser = ac.getUser();
        System.out.println(acUser);


        model.addAttribute("accompanyList", accompanyEntity);


        return "community/accompany/accompany";

    }


    //동행 글 쓰기
    @GetMapping("/community/accompany/write") // http://localhost:8070/community/accompany/write
    public String accompanyWrite(
            HttpSession session
    ) {

        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/community/home";
        }

        return "community/accompany/accompany_write";
        /*"community/accompany/accompany_write";*/

    }

    @PostMapping("/community/accompany/writePro") // http://localhost:8070/community/accompany/write
    public String accompanywritePro(HttpSession session, AccompanyForm form,
                                    @RequestParam("ac_region") String ac_region,
                                    @RequestParam("ac_startdate") String ac_startdate,
                                    @RequestParam("ac_enddate") String ac_enddate,
                                    @RequestParam("ac_title") String ac_title,
                                    @RequestParam("ac_text") String ac_text,
                                    @RequestParam("ac_people") String ac_people,
                                    @RequestParam("ac_picture") String ac_picture
    ) {
        System.out.println(form);
        form.setAc_viewcount(0);
        // 조회수 0 으로 초기화

        User user = (User) session.getAttribute("user");
        System.out.println("user" + user);
        Long getUNumber = user.getUserNumber();
        form.setUser_number(getUNumber);
        // 유저 넘버 가져옴

        System.out.println("ac_region" + ac_region);
        System.out.println("ac_startdate" + ac_startdate);
        System.out.println("ac_enddate" + ac_enddate);
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


    // 위와 같은 메서드

    // index에서 해당 글로 연결

    @GetMapping("community/accompany/detail")
    public String AccompanyDetail(@RequestParam("ac_num") Long ac_num, Model model) {
        System.out.println("컨트롤러의 AccompanyDetail() 메서드를 실행");
        System.out.println("ac_num = " + ac_num);


        Accompany accompanyEntity = accompanyRepository.findById(ac_num).orElse(null);

        //테이블에서 데이터를 가져와서 accompany_Detail파일로 넘기기 위해서
        // model 인터페이스 객체에 넣어준다.
        System.out.println("accompanyEntity : " + accompanyEntity);
        model.addAttribute("accompany", accompanyEntity);

        return "community/accompany/accompany_detail";

    }


    // 동행 글의 수정 클릭 > 해당 글 번호 불러오기
    @GetMapping("community/accompany/edit")
    public String index(@RequestParam("ac_num") Long ac_num, Model model) {
        System.out.println("컨트롤러의 edit() 메서드를 실행");
        System.out.println("ac_num=" + ac_num);

//        User user = (User) session.getAttribute("user");
//
//        if ( user == null) {
//
//            return "redirect:/";
//        }

        // 수정할 데이터를 얻어온다.
        Accompany accompanyEntity = accompanyRepository.findById(ac_num).orElse(null);

        // 테이블에서 데이터를 가져와서 edit.html 로 파일을 넘기기 위해서
        // model 인터페이스 객체에 넣어준다.

        model.addAttribute("accompany", accompanyEntity);

        return "community/accompany/accompany_edit";

    }

//    // 글 번호를 가지고 수정하는 메서드
//    @RequestMapping(value = "/community/accompany/update", produces="text/plain;charset=UTF-8")
//    public String accompanyUpdate(HttpServletRequest request, AccompanyForm form){
//        System.out.println("컨트롤러 update() 메서드 실행");
//        System.out.println(form.toString());
//
//        System.out.println(form.getUser_number());
//        System.out.println(form.getAc_region());
//
//        // 수정한 글 1건만 보여주고 싶을 때는
//        return "redirect://community/accompany";
//    }


    // 글 번호를 가지고 수정하는 메서드
    // http://localhost:8070/community/accompany/update
    @ResponseBody
    @PostMapping("/community/accompany/update")
    public String Accompanyupdate(
                                  Model model, //모델
                                  @ModelAttribute("accompany") Accompany session_accompany,
                                  @RequestBody AccompanyForm form,
                                  HttpSession session
    ) {
        System.out.println("컨트롤러 update() 메서드 실행");
        System.out.println("form 이야" + form);
        System.out.println("session_accompany 이야" + session_accompany.toString());



        User user = (User) session.getAttribute("user");
        System.out.println("user 야" + user);
        Long getUserNumber = user.getUserNumber();
        form.setUser_number(getUserNumber);
//        // 유저 넘버 가져옴

         // DTO -> Entity 로 변환한다.
        Accompany accompany = form.toEntity();
//        Date date = new Date();


        Accompany result = accompanyService.updateAccompany(accompany);

        model.addAttribute("accompany", result);

        System.out.println(accompany);
        System.out.println(result);

        // 수정한 글 1건만 보여주고 싶을 때는
        return "redirect:/community/accompany";

    }


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