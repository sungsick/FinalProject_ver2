package com.kh.myproject.community.accompany.controller;


import com.kh.myproject.community.accompany.dto.CommentForm;
import com.kh.myproject.community.accompany.entity.Accompany;
import com.kh.myproject.community.accompany.entity.Comment;
import com.kh.myproject.community.accompany.repository.CommentRepository;
import com.kh.myproject.community.accompany.service.CommentService;
import com.kh.myproject.member.user.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes({"user", "accompany"})
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CommentService commentService;




    @PostMapping("/community/accompany/reWritePro") // http://localhost:8070/community/accompany/write
    public String commentWritePro(
                                    HttpSession session,
                                    CommentForm form,
                                    @RequestParam("co_content") String co_content
                                    ) {

        User user = (User)session.getAttribute("user");
        Accompany accompany = (Accompany)session.getAttribute("accompany");


        // Repository에게 Entity를 데이터베이스에 저장하게 한다
        // id 가 자동으로 증가된다.

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // DTO의 데이터를 Entity로 변환한다.
        form.setCo_content(co_content);
        form.setCo_regdate(sdf.format(date));
        form.setUser(user);
        form.setAccompany(accompany);
        Comment comment = form.toEntity();
        Comment saved = commentRepository.save(comment);
        System.out.println("form 태그 세터로 세팅 후 comment값" + comment);


        return "redirect:/community/accompany/detail?ac_num="+ accompany.getAc_num();
        /*"community/accompany/accompany_write";*/

    }


     //댓글 목록 보기
    /*@GetMapping("community/accompany/detail") // http://localhost:8070/community/accompany
    public String commentList(@RequestParam("ac_num") Long ac_num, Model model) {

        System.out.println("컨트롤러의 commentList() 실행");
        // 목록보기

        // db에서 정보를 가져오는 locig을 짜야함

        List<Comment> commentEntity = (List<Comment>) commentRepository.findById(ac_num).orElse(null);
        Comment co = commentEntity.get(0);
        User user = co.getUser();
        Accompany accompany = co.getAc_num();

        System.out.println("comment entity에 있는 user값 : " + user);
        System.out.println("comment entity에 있는 user값 : " + accompany);

        model.addAttribute("commentList : ", commentEntity);


        return "redirect:community/accompany/detail?ac_num="+ac_num;
    }*/


}

//    //클릭으로 동행게시글을 들어갔을떄
//    @GetMapping("community/accompany/detail")
//    public String AccompanyDetail(@RequestParam(value = "ac_num",defaultValue = "0") Long ac_num,
//                                  Model model) {
//        System.out.println("컨트롤러의 AccompanyDetail() 메서드를 실행");
//        System.out.println("ac_num = " + ac_num);
//
//        // 해당페이지로 접속시 해당 게시글의 조회수를 올려줘야한다. 조회수가 올라간 상태로 게시글을 반환해야한다.
//        Accompany accompanyEntity = accompanyRepository.findById(ac_num).orElse(null);
//        accompanyService.increaseViewCount(accompanyEntity.getAc_num()); // 객체를 찾아오기전에 미리 조회수를 올리고 찾아오기보다는 찾아오고 있을때 걔의조회수를 올려야하는데
//        // 그러면 클라이언트는 증가되기전의 조회수를 보므로 임의로 객체의 변수값을 바꿔준다.
//        accompanyEntity.setAc_viewcount(accompanyEntity.getAc_viewcount()+1);
//
//
//        model.addAttribute("accompany", accompanyEntity);
//
//        return "community/accompany/accompany_detail";
//
//    }
//

//    //동행 리스트(동행 메인)
//    @GetMapping("/community/accompany") // http://localhost:8070/community/accompany
//    public String communityaccompany(Model model) {
//
//
//        System.out.println("컨트롤러의 ");
//        // 목록보기
//
//        // db에서 정보를 가져오는 locig을 짜야함
//        List<Accompany> accompanyEntity = accompanyRepository.findAll();
//        Accompany ac = accompanyEntity.get(0);
//        User acUser = ac.getUser();
//        System.out.println(acUser);
//
//
//        model.addAttribute("accompanyList", accompanyEntity);
//
//
//
//        return "community/accompany/accompany";
//    }
//
//
//    //동행 글 쓰기
//    @GetMapping("/community/accompany/write") // http://localhost:8070/community/accompany/write
//    public String accompanyWrite(
//            HttpSession session
//    ) {
//
//        User user = (User) session.getAttribute("user");
//        if (user == null) {
//            return "redirect:/community/home";
//        }
//
//        return "community/accompany/accompany_write";
//        /*"community/accompany/accompany_write";*/
//
//    }
//

//
//
//
//

//
////    // 동행 게시글에 댓글 달기.
////    @PostMapping("/community/accompany/detailCoWrite")
////    public List<Comment> detailCoWrite(
////            @ModelAttribute("user_number") Long user_number,
////            @ModelAttribute("commentValue") Long commentValue){
////
////        // 해당 게시글의 댓글리스트를 모조리 가지고온다.
////        System.out.println(user_number);
////        System.out.println(commentValue);
////
//////        List<Comment> commentList = commentService.findByUser(accompanyEntity.getUser());
////
////        return new List<Comment>();
////    }
////
////
//
//
//
//
//
//
//
//    // 동행 글의 수정 클릭 > 해당 글 번호 불러오기
//    @GetMapping("community/accompany/edit")
//    public String accompanyEdit(@RequestParam("ac_num") Long ac_num, Model model) {
//
//
//        System.out.println("컨트롤러의 edit() 메서드를 실행");
//        System.out.println("ac_num=" + ac_num);
//
////        User user = (User) session.getAttribute("user");
////
////        if ( user == null) {
////
////            return "redirect:/";
////        }
//
//        // 수정할 데이터를 얻어온다.
//        Accompany accompanyEntity = accompanyRepository.findById(ac_num).orElse(null);
//
//        // 테이블에서 데이터를 가져와서 edit.html 로 파일을 넘기기 위해서
//        // model 인터페이스 객체에 넣어준다.
//
//        model.addAttribute("accompany", accompanyEntity);
//
//        return "community/accompany/accompany_edit";
//
//    }
//
////    // 글 번호를 가지고 수정하는 메서드
////    @RequestMapping(value = "/community/accompany/update", produces="text/plain;charset=UTF-8")
////    public String accompanyUpdate(HttpServletRequest request, AccompanyForm form){
////        System.out.println("컨트롤러 update() 메서드 실행");
////        System.out.println(form.toString());
////
////        System.out.println(form.getUser_number());
////        System.out.println(form.getAc_region());
////
////        // 수정한 글 1건만 보여주고 싶을 때는
////        return "redirect://community/accompany";
////    }
//
//
//    // 글 번호를 가지고 수정하는 메서드
//    // http://localhost:8070/community/accompany/update
//    @ResponseBody
//    @PostMapping("/community/accompany/update")
//    public String Accompanyupdate(
//                                  Model model, //모델
//                                  @RequestBody AccompanyForm form,
//                                  HttpSession session
//    ) {
//        System.out.println("컨트롤러 update() 메서드 실행");
//        System.out.println("form 이야" + form);
//
//        User user = (User) session.getAttribute("user");
//        Long getUserNumber = user.getUserNumber();
//        form.setUser(user);
//        form.getUser().setUserNumber(getUserNumber);
//
////        // 유저 넘버 가져옴
//
//         // DTO -> Entity 로 변환한다.
//        Accompany accompany = form.toEntity();
////        Date date = new Date();
//
//
//        Accompany result = accompanyService.updateAccompany(accompany);
//
//        model.addAttribute("accompany", result);
//
//        System.out.println(accompany);
//        System.out.println(result);
//
//        // 수정한 글 1건만 보여주고 싶을 때는
//        return "redirect:/community/accompany";
//
//    }
//
//
//
//    // 글 삭제하기
//    @ResponseBody
//    @PostMapping("/community/accompany/delete")
//    public String Accompanydelete(@RequestParam("ac_num") Long ac_num,
//                                  RedirectAttributes rttr) {
//
//        //RedirectAttributes : 리디렉션을 수행할때, 다른컨트롤러 메서드로 attributes를 전달하는데 이용
//        // addAttribute() : 주소창에 정보 노출되어도 상관없는 정보 보임, 정보 넘김
//
//        //addFlashAttribute 의 경우 데이타가 post 형식으로 전달,
//        // 세션에 저장되고 오직 다음요청에서만 접근 가능, 세션에 저장되어 사용된 뒤 자동 삭제
//        // 검증결과, 성공 실패여부 메세지 등 임시 사용되는 데이터에 사용, 주소창에 표기되지 x
//
//        System.out.println("컨트롤러 delete() 메서드를 실행");
//        System.out.print("ac_num : " + ac_num);
//
//
//        // 삭제할 데이터를 가져온다.
//        Accompany accompanyEntity = accompanyRepository.findById(ac_num).orElse(null);
//        System.out.println(accompanyEntity.toString());
//
//        //데이터 삭제
//        if(accompanyEntity != null) {
//            accompanyRepository.delete(accompanyEntity);
//
//            rttr.addFlashAttribute("msg", ac_num + "번 글 삭제 완료!");
//        }
//
//        return "redirect:/community/accompany";
//    }
//
//
////    //동행 글 정보
////    @GetMapping("/community/accompany/detail/{ac_num}") // http://localhost:8070/community/accompany
////    public String communityAccompanyDetail(@PathVariable Long ac_num, Model model){
////
////        System.out.println("컨트롤러의 show() 메서드 실행");
////        System.out.println("ac_num = " + ac_num);
////
////        // ac_num 한 건마다 해당되는 테이블에서 가지고 온다.
////        // findById() id 값을 넣어주면 테이블에서 찾아서 결과를 반환한다.
////        // 만약 데이터가 없다면 orElse(null) 메서드가 실행하면 null을 리턴시킨다.
////
////        Accompany accompanyEntity = accompanyRepository.findById(ac_num).orElse(null);
////
////        model.addAttribute("accompany", accompanyEntity);
////
////        return "community/accompany/accompany_detail";
////
////    }
////
////
//
//
//
//
//
//}