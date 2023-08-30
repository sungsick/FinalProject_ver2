package com.kh.myproject.store.flight.controller;

import com.kh.myproject.member.user.model.entity.User;
import com.kh.myproject.store.flight.model.dto.FlightTicketDto;
import com.kh.myproject.store.flight.model.entity.TicketInfo;
import com.kh.myproject.store.flight.service.FlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
@SessionAttributes("user")
@Slf4j
public class FlightController {

    @Autowired
    FlightService flightService;
    //공항리스트
    final String airportUrl = "https://apis.data.go.kr/1613000/DmstcFlightNvgInfoService/getArprtList?";
    //노선목록
    final String flightOpratInfoUrl = "http://apis.data.go.kr/1613000/DmstcFlightNvgInfoService/getFlightOpratInfoList?";
    private final String serviceKey = "serviceKey=ZgRTKBFIJGjeIJ14VHOZrP9UMtis8xSBTJvnPqQIigzUQ4aIL8V03y5XCVZ5B8GAKHaJX%2FOz2UpnX%2FvgKqv38w%3D%3D&";
    private FlightTicketDto ticketDto;

    /*@GetMapping("/store/flight/flights")
    public ModelAndView flightMain(ModelAndView mav){

        mav.setViewName("store/flight/flights");
        return mav;
    }*/
    @GetMapping("/store/flight/flights")
    public ModelAndView flightMain(@RequestParam(value = "startAirport", required = false) String startAirport,
                                   @RequestParam(value = "endAirport", required = false) String endAirport,
                                   @RequestParam(value = "startDate", required = false) String startDate,
                                   ModelAndView mav) {

        log.info("startAirport={}", startAirport);
        log.info("endAirport={}", endAirport);

        if (startAirport != null) {
            mav.addObject("startAirport", startAirport);
            mav.addObject("endAirport", endAirport);
            mav.addObject("startDate", startDate);
        }

        mav.setViewName("store/flight/flights");

        return mav;
    }

    @GetMapping("/store/flight/flightTest1")
    public ModelAndView flightTest(ModelAndView mav,
                                   @ModelAttribute("user") User user) {

        List<TicketInfo> list = flightService.getTicketList(user.getUserNumber());
        log.info("ticketDto={}", ticketDto);
        for (TicketInfo item : list) {
            log.info("ticketItem={}", item);
        }
        mav.addObject("ticket", ticketDto);
        mav.setViewName("/store/flight/flightTest");
        return mav;
    }

    @GetMapping("/store/flight/airportList")
    public ResponseEntity<?> getAirportList() {
        String url = airportUrl;
        url += serviceKey + "&_type=json";
        return ResponseEntity.ok(flightService.getFlightList(url));
    }

    @GetMapping("/tour/flight/searchFlight")
    public ResponseEntity<?> searchFlight(@RequestParam("startAirport") String startAirport,
                                          @RequestParam("endAirport") String endAirport,
                                          @RequestParam("startDate") String startDate,
                                          @RequestParam("pageNo") int pageNo,
                                          Model model) {

        log.info("startAirport={}", startAirport);
        log.info("endAirport={}", endAirport);
        log.info("startDate={}", startDate);
        log.info("pageNo={}", pageNo);


        String url = flightOpratInfoUrl;
        url += serviceKey + "pageNo=" + pageNo + "&depAirportId=" + startAirport + "&arrAirportId=" + endAirport +
                "&depPlandTime=" + startDate.replace("-", "") + "&_type=json";


        return ResponseEntity.ok(flightService.getFlightList(url));
    }

    @PostMapping("/store/flight/saveFlight")
    public void saveFlight(@RequestBody FlightTicketDto ticket,
                           @ModelAttribute("user") User user,
                           ModelAndView mav) {
        log.info("ticket={}", ticket);
        log.info("user={}", user.getUserId());
        ticket.setUser(user);
//        mav.addObject("ticket",ticket);
        ticketDto = ticket;
        TicketInfo ticketInfo = ticketDto.toEntity();

        flightService.saveFlight(ticketInfo);
    }

    @GetMapping("/store/flight/remove")
    public ModelAndView removeTicket(@RequestParam("ticketId")Long ticketId,
                                     ModelAndView mav){
        flightService.removeTicket(ticketId);

        mav.setViewName("store/tour/tourmain");
        return mav;
    }


}
