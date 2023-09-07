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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes("user")
public class AccompanyController {

    @Autowired
    AccompanyRepository accompanyRepository;

    @Autowired
    AccompanyService accompanyService;

    //여행커뮤니티 홈(메인페이지 병합 전 삭제)
    @GetMapping("/community/home") //http://localhost:8070/community/home
    public String communityhome() {

        System.out.println("communityhome 테스트..");

        return "community/home";
    }


    //동행 리스트(동행 메인)
    @GetMapping("/community/accompany") // http://localhost:8070/community/accompany
    public String communityaccompany(Model model) {


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
    public String accompanywritePro(
                                    HttpSession session,
                                    AccompanyForm form,
                                    @RequestParam(value = "start_date",defaultValue = "") String start_date,
                                    @RequestParam(value = "end_date" ,defaultValue = "") String end_date,
                                    @RequestParam(value = "ac_region",defaultValue = "") String ac_regionp,
                                    @RequestParam("ac_title") String ac_title,
                                    @RequestParam("ac_text") String ac_text,
                                    @RequestParam("ac_people") String ac_people,
                                    @RequestParam("accompany_image") MultipartFile multipartFile) {


        User user = (User)session.getAttribute("user");
        // accompany 의 date는 java에서도 date타입이기 때문에 우선은 form데이터를 받을때는 string으로 받지만 이후에 date타입으로 포매팅 시켜서 저장한다.
        // date타입으로 처리할떄의 장점은 날짜 계산이 편하다는 것이다. 물론 db에서 날짜를 가져오기를 start_date와 end_date를 diff함수를 이용해
        // 날짜 차이를 가지고 올 수 있기는 하지만 여러개의 글을 동시에 보여줘야하는 경우가 있기 때문에 글목록을 보여줄때마다 항상 날짜의 차이를 따로 가지고 올수는 없다.

        System.out.println("file값 : accompany_image" + multipartFile);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


        // form데이터로 넘어온 문자열 형태의 날짜를 date타입으로 파싱 시킨다.
        Date ac_startdate = new Date();
        Date ac_enddate = new Date();
        try {
            ac_startdate = sdf.parse(start_date);
            ac_enddate = sdf.parse(end_date);
        }catch (Exception e){

            e.printStackTrace();
        }


        // image명은 현재 accompany게시글의 최대값 +1 + .확장자명으로 지정한다.
        int ac_max = accompanyService.getMaxAcNum();
        String ac_picture = accompanyService.saveAccompanyImage(String.valueOf("acc" +(ac_max + 1)),multipartFile);

        // Repository에게 Entity를 데이터베이스에 저장하게 한다
        // id 가 자동으로 증가된다.


        // DTO의 데이터를 Entity로 변환한다.
        form.setAc_picture(ac_picture);
        form.setAc_enddate(ac_enddate);
        form.setAc_startdate(ac_startdate);
        form.setAc_regdate(new Date());
        form.setUser(user);
        Accompany accompany = form.toEntity();
        Accompany saved = accompanyRepository.save(accompany);
        System.out.println("form 태그 세터로 세팅 후 " + accompany);


        return "redirect:/community/accompany";
        /*"community/accompany/accompany_write";*/

    }





    //클릭으로 동행게시글을 들어갔을떄
    @GetMapping("community/accompany/detail")
    public String AccompanyDetail(@RequestParam(value = "ac_num",defaultValue = "0") Long ac_num,
                                  Model model) {
        System.out.println("컨트롤러의 AccompanyDetail() 메서드를 실행");
        System.out.println("ac_num = " + ac_num);

        // 해당페이지로 접속시 해당 게시글의 조회수를 올려줘야한다. 조회수가 올라간 상태로 게시글을 반환해야한다.
        Accompany accompanyEntity = accompanyRepository.findById(ac_num).orElse(null);
        accompanyService.increaseViewCount(accompanyEntity.getAc_num()); // 객체를 찾아오기전에 미리 조회수를 올리고 찾아오기보다는 찾아오고 있을때 걔의조회수를 올려야하는데
        // 그러면 클라이언트는 증가되기전의 조회수를 보므로 임의로 객체의 변수값을 바꿔준다.
        accompanyEntity.setAc_viewcount(accompanyEntity.getAc_viewcount()+1);


        model.addAttribute("accompany", accompanyEntity);

        return "community/accompany/accompany_detail";

    }


//    // 동행 게시글에 댓글 달기.
//    @PostMapping("/community/accompany/detailCoWrite")
//    public List<Comment> detailCoWrite(
//            @ModelAttribute("user_number") Long user_number,
//            @ModelAttribute("commentValue") Long commentValue){
//
//        // 해당 게시글의 댓글리스트를 모조리 가지고온다.
//        System.out.println(user_number);
//        System.out.println(commentValue);
//
////        List<Comment> commentList = commentService.findByUser(accompanyEntity.getUser());
//
//        return new List<Comment>();
//    }
//
//







    // 동행 글의 수정 클릭 > 해당 글 번호 불러오기
    @GetMapping("community/accompany/edit")
    public String accompanyEdit(@RequestParam("ac_num") Long ac_num, Model model) {


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
                                  @RequestBody AccompanyForm form,
                                  HttpSession session
    ) {
        System.out.println("컨트롤러 update() 메서드 실행");
        System.out.println("form 이야" + form);

        User user = (User) session.getAttribute("user");
        Long getUserNumber = user.getUserNumber();
        form.setUser(user);
        form.getUser().setUserNumber(getUserNumber);

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



    // 글 삭제하기
    @ResponseBody
    @PostMapping("/community/accompany/delete")
    public String Accompanydelete(@RequestParam("ac_num") Long ac_num,
                                  RedirectAttributes rttr) {

        //RedirectAttributes : 리디렉션을 수행할때, 다른컨트롤러 메서드로 attributes를 전달하는데 이용
        // addAttribute() : 주소창에 정보 노출되어도 상관없는 정보 보임, 정보 넘김

        //addFlashAttribute 의 경우 데이타가 post 형식으로 전달,
        // 세션에 저장되고 오직 다음요청에서만 접근 가능, 세션에 저장되어 사용된 뒤 자동 삭제
        // 검증결과, 성공 실패여부 메세지 등 임시 사용되는 데이터에 사용, 주소창에 표기되지 x

        System.out.println("컨트롤러 delete() 메서드를 실행");
        System.out.print("ac_num : " + ac_num);


        // 삭제할 데이터를 가져온다.
        Accompany accompanyEntity = accompanyRepository.findById(ac_num).orElse(null);
        System.out.println(accompanyEntity.toString());

        //데이터 삭제
        if(accompanyEntity != null) {
            accompanyRepository.delete(accompanyEntity);

            rttr.addFlashAttribute("msg", ac_num + "번 글 삭제 완료!");
        }

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





}