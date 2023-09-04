package com.kh.myproject.store.flight.service;

import com.kh.myproject.member.user.model.entity.User;
import com.kh.myproject.store.flight.model.entity.FlightTicketInfo;
import com.kh.myproject.store.flight.repository.FlightTicketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
@Slf4j
public class FlightService {

    @Autowired
    private FlightTicketRepository flightRepository;

    public void saveFlight(FlightTicketInfo TicketInfo){

        flightRepository.save(TicketInfo);
    }

    public List<FlightTicketInfo> getTicketList(Long userNum){
        return flightRepository.findByUser_UserNumber(userNum);
    }

    public void removeTicket(Long ticketId){
        flightRepository.deleteById(ticketId);
    }
    public String getFlightList(String url){

        StringBuilder result = new StringBuilder();

        try{
            URL resUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) resUrl.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;

            while((line = br.readLine()) != null){
                result.append(line);
            }
            br.close();
            conn.disconnect();
            System.out.println(result);

        } catch(Exception e){
            e.printStackTrace();
        }

        return result.toString();
    }
    
    
    // 여기서부터 manager에서 항공 정보를 가져오기 위한 쿼리문
    
    
    public int selectTicketCount(){
        
        int result = flightRepository.selectTicketCount();
        return result;
    }
    
    public List<FlightTicketInfo> findTicketByPage(int pageNo){

        //        flightRepository.findUserByPage(startNo,endNo);
        Pageable pageable = PageRequest.of(pageNo-1,10);
        Page<FlightTicketInfo> tickets = flightRepository.findAll(pageable);
        List<FlightTicketInfo> ticketList = tickets.getContent();

        
        return ticketList;
    }

    public List<FlightTicketInfo> selectTicketBySearchWord(int pageNo,String search_word,String search_option){

        Page<FlightTicketInfo> ticketList = null;
        Pageable pageable = PageRequest.of(pageNo-1,10); // 정렬기능 추가안했음.

        if(search_option.equals("ticAirlineName")){ // 항공사명으로 조회했을 떄

            ticketList = flightRepository.findByTicAirlineNameLike(pageable,"%" + search_word +"%");
        }else if(search_option.equals("user_name")){ // 예약자명으로 조회했을 떄
            ticketList = flightRepository.findByUserNameLike(pageable,"%" + search_word+ "%");

        }

        List<FlightTicketInfo> resultList = ticketList.getContent();
        System.out.println(resultList);


        return resultList;
    }

    public int countBysearchWorld(String search_word, String search_option){

        int result = 0;

        if(search_option.equals("user_id")){
            result = flightRepository.countByUserNameTLike("%" + search_word +"%");
        }else if(search_option.equals("ticAirlineName"))
            result = flightRepository.countByTicAirlineNameLike("%" + search_word +"%");

        return result;
    }


    public void deleteTicket(Long ticTicketId){

        flightRepository.deleteById(ticTicketId);
    }

    public List<FlightTicketInfo> findAll(){

        return flightRepository.findAll();
    }

    public void deleteTicketByUserNumber(Long user_number){

        flightRepository.deleteByUserNumber(user_number);
    }


}
