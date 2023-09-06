package com.kh.myproject.api.kakaoPay.controller;

import com.kh.myproject.api.kakaoPay.model.dto.KakaoPayApprovalVO;
import com.kh.myproject.api.kakaoPay.model.dto.KakaoPayReadyVO;
import com.kh.myproject.api.kakaoPay.service.PayService;
import com.kh.myproject.api.kakaoPay.service.SeleniumComponent;
import com.kh.myproject.member.user.model.entity.User;
import com.kh.myproject.store.flight.model.dto.FlightTicketDto;
import com.kh.myproject.store.flight.model.entity.FlightTicketInfo;
import com.kh.myproject.store.flight.repository.FlightTicketRepository;
import com.kh.myproject.store.rentcar.model.dto.CrawlingDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@SessionAttributes({"tid", "user"}) // 세션에 저장된 값 탐색
public class PayController {

    @Autowired
    FlightTicketRepository flightTicketRepository;
    private final PayService payService;
    private FlightTicketDto ticketDto;

    private SeleniumComponent seleniumComponent;

    // 결제버튼 클릭시 결제 페이지
    @GetMapping("/pay/payButton")
    public ModelAndView payButton() {
        ModelAndView payButton = new ModelAndView();
        payButton.setViewName("pay/payButton");
        return payButton;
    }

    // rentcar 예약 페이지
    @GetMapping("/pay/paymentPage")
    public ModelAndView paymentPage() throws IOException {

//        String URL = "https://whitelabel.imsmobility.co.kr/tripsoda/reservation/request/247?pickupAt=2023-09-06T01%3A00%3A00.000Z&dropoffAt=2023-09-07T01%3A00%3A00.000Z&pickupLat=33.50707895781836&pickupLng=126.492769004244&birth=000101&pickupAddress=%EC%A0%9C%EC%A3%BC%EA%B5%AD%EC%A0%9C%EA%B3%B5%ED%95%AD&pickupFullAddress=%EC%A0%9C%EC%A3%BC%ED%8A%B9%EB%B3%84%EC%9E%90%EC%B9%98%EB%8F%84+%EC%A0%9C%EC%A3%BC%EC%8B%9C+%EA%B3%B5%ED%95%AD%EB%A1%9C+2+%EC%A0%9C%EC%A3%BC%EA%B5%AD%EC%A0%9C%EA%B3%B5%ED%95%AD&insuranceAge=21&isJeju=true&sortOption=low_price&rentType=DAILY&submodelId=2";
//        Document doc = Jsoup.connect(URL).get();
//        Elements reviews = doc.select("div .StyledReviewBox-kQYaKO XkTcB");
//        List
//        for (Element review : reviews) {
//            System.out.println(review.text());
//
//        }
        ModelAndView paymentPage = new ModelAndView();
        paymentPage.setViewName("pay/paymentPage");
        return paymentPage;
    }

    // flight 예약 페이지
    @GetMapping("/pay/flightPaymentPage")
    public ModelAndView flightPaymentPage(@ModelAttribute("ticket") FlightTicketDto ticket) {
        ModelAndView flightPaymentPage = new ModelAndView();
        flightPaymentPage.addObject("ticket", ticket);
        flightPaymentPage.setViewName("pay/flightPaymentPage");
        return flightPaymentPage;
    }

    // api 결제요청
    @PostMapping("/kakaoPay")
    // RedirectView 형식으로 html에서 카카오 api 호출시 CORS오류 (보안정책이라고 함). @ResponseBody로 POST 캡슐화 후 readyResponse 직접 호출하니 해결됨.
    public @ResponseBody KakaoPayReadyVO kakaoPay(@RequestBody FlightTicketDto ticket,
                                                  @ModelAttribute("user") User user) {
        // 티켓에 유저정보 추가
        ticket.setUser(user);

        // 결제 완료시 데이터 저장을 위해 전역변수에 저장
        ticketDto = ticket;

        log.info("kakaoPay post.....................................");
        KakaoPayReadyVO readyResponse = payService.kakaoPayReady(ticket);
        log.info(".........................결제고유 번호 : " + readyResponse.getTid());

        return readyResponse;
    }

    // api 결제 승인요청 / 완료시 데이터 저장
    @GetMapping("/pay/success")
    public ModelAndView kakaoPayCompleted(@RequestParam("pg_token") String pg_token, Model model) {
        log.info("kakaoPaySuccess get......................");
        log.info("kakaoPaySuccess pg_token : " + pg_token);

        // 카카오 결재 요청하기
        KakaoPayApprovalVO approveResponse = payService.payApprove(pg_token);
        model.addAttribute("info", approveResponse);
        log.info("approveResponse : " + approveResponse);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pay/success");
        log.info("info : " + approveResponse);

        // 결제 완료시 결제고유번호 tid 추가
        ticketDto.setTid(approveResponse.getTid());

        // ticketDto toENtity
        FlightTicketInfo ticketEntity = ticketDto.toEntity();

        log.info("=================ticketEntity{}", ticketEntity);
        // 결제 데이터 저장
        flightTicketRepository.save(ticketEntity);

        return modelAndView;
    }

    // 결제 취소시 실행 url
    @GetMapping("/pay/cancel")
    public ModelAndView payCancel() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pay/cancel");
        return modelAndView;
    }

    // 결제 실패시 실행 url
    @GetMapping("/pay/fail")
    public ModelAndView payFail() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pay/fail");
        return modelAndView;
    }

    //test 전용
    @GetMapping("/pay/test11")
    public ModelAndView test11(Model model) throws InterruptedException {
        List<CrawlingDto> reviews = seleniumComponent.getReviews();
        model.addAttribute("reviews", reviews);
        ModelAndView test11 = new ModelAndView();
        test11.setViewName("pay/test11");
        return test11;
    }
}

//    @GetMapping("/pay/reviewCrawling")
//    public String reviewCrlw(Model model) throws Exception {
//        List<CrawlingDto> reviews = crawlingService.getReviewDatas();
//        model.addAttribute("reviews", reviews);
//
//        return "";
//    }
//}



