package com.kh.myproject.store.rentcar.cotroller;

import com.kh.myproject.store.rentcar.model.RentcarComDTO;
import com.kh.myproject.store.rentcar.model.RentcarInfoDTO;
import com.kh.myproject.store.rentcar.repository.RentcarRepository;
import com.kh.myproject.store.rentcar.service.RentcarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Slf4j
@SessionAttributes("user")
public class RentcarController {

    @Autowired
    private RentcarService rentcarService;

    @Autowired
    private RentcarRepository rentcarRepository;


    @GetMapping("/store/rentcar/rentcarMain")
    public String rentcarMain() {

        return "store/rentcar/rentcarMain";

    }

    /*
        @GetMapping("/store/rentcar/rentcarReserve")
        public String rentcarReserve() {

            return "store/rentcar/rentcarReserve";

        }


        @GetMapping("/store/rentcar/rentcarChoice")
        public String rentcarChoice() {

            return "store/rentcar/rentcarChoice";

        }

    */
    @RequestMapping("/MainSearch") // http://localhost:8080/store/rentcar/MainSearch
    public String sample(@RequestParam String input_location,
                         @RequestParam String depart_date,
                         @RequestParam String arrive_date,
                         @RequestParam String input_birth,
                         Model model) {

        System.out.println(input_location);
        System.out.println(depart_date);
        System.out.println(arrive_date);
        System.out.println(input_birth);

        model.addAttribute("input_location", input_location);
        model.addAttribute("depart_date", depart_date);
        model.addAttribute("arrive_date", arrive_date);
        model.addAttribute("input_birth", input_birth);

        return "store/rentcar/rentcarReserve";

    }


/*

    @GetMapping("/store/rentcar/thTest")
    public String thttt(){

        return "store/rentcar/thTest";
    }

*/


    @GetMapping("/rentcarReserve")
    public ResponseEntity<List<RentcarInfoDTO>> reserveSearch(@RequestParam(value = "searchKeyword") String searchKeyword) {

        System.out.println("reserveSearch 컨트롤러 메서드 실행");
        System.out.println(searchKeyword);

        List<RentcarInfoDTO> rentcarList = rentcarService.searchKeyword(searchKeyword);

        return ResponseEntity.ok(rentcarList);


    }

    @GetMapping("/highPriceList")
    public ResponseEntity<List<RentcarInfoDTO>> highPriceList() {


        List<RentcarInfoDTO> rentcarList = rentcarService.FindDiscountDesc(rentcarService.findAll());

        return ResponseEntity.ok(rentcarList);
    }


    @GetMapping("/lowPriceList")
    public ResponseEntity<List<RentcarInfoDTO>> lowPriceList() {


        List<RentcarInfoDTO> rentcarList = rentcarService.FindDiscountAsc(rentcarService.findAll());

        return ResponseEntity.ok(rentcarList);
    }

    @GetMapping("/carTypeList")
    public ResponseEntity<List<RentcarInfoDTO>> carTypeList() {


        List<RentcarInfoDTO> rentcarList = rentcarService.FindTypeAsc(rentcarService.findAll());

        return ResponseEntity.ok(rentcarList);
    }


    @RequestMapping("/rentcarChoice")
    public String rentcarChoice(@RequestParam String input_location,
                                                             @RequestParam String depart_date,
                                                             @RequestParam String arrive_date,
                                                             @RequestParam String input_birth,
                                                             @RequestParam String car_name,
                                                            Model model) {
        List<RentcarComDTO> rentcarComDTOList = rentcarService.getComSelect(car_name);

        model.addAttribute("input_location", input_location);
        model.addAttribute("depart_date", depart_date);
        model.addAttribute("arrive_date", arrive_date);
        model.addAttribute("input_birth", input_birth);
        model.addAttribute("rentcarComDTOList", rentcarComDTOList);

        return "store/rentcar/rentcarChoice";

    }


/*
    @GetMapping("/store/rentcar/rentcarMain")
    public ModelAndView rentcarMain(ModelAndView mav) {

        mav.setViewName("store/rentcar/rentcarMain");

        return mav;
    }


    @GetMapping("/store/rentcar/rentcarReserve")
    public ModelAndView rentcarReserve(ModelAndView mav) {

        mav.setViewName("store/rentcar/rentcarReserve");

        return mav;
    }

    @GetMapping("/store/rentcar/rentcarChoice")
    public ModelAndView rentcarChoice(ModelAndView mav) {

        mav.setViewName("store/rentcar/rentcarChoice");

        return mav;
    }






    //main에서 검색버튼 누른 후 reserve로 넘어가는 메서드
    @GetMapping("/store/rentcar/rentcarMainSearch")
    public ModelAndView mainSearch(        @RequestParam("location") String location,
                                           @RequestParam("departDate") String departDate,
                                           @RequestParam("arriveDate") String arriveDate,
                                           @RequestParam("birthDate") String birthDate,
                                           ModelAndView mav){

        log.info("location", location);
        log.info("departDate",departDate);
        log.info("arriveDate",arriveDate);
        log.info("birthDate",birthDate);



        mav.addObject("location", location);
        mav.addObject("departDate", departDate);
        mav.addObject("arriveDate", arriveDate);
        mav.addObject("birthDate", birthDate);


        mav.setViewName("store/rentcar/thTest");

        return mav;

    }


 */

}
