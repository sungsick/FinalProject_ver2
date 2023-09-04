package com.kh.myproject.store.flight.repository;

import com.kh.myproject.member.user.model.entity.User;
import com.kh.myproject.store.flight.model.entity.FlightTicketInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface FlightTicketRepository extends JpaRepository<FlightTicketInfo, Long> {
    List<FlightTicketInfo> findByUser_UserNumber(Long userNumber);




    @Query("select count(*) from FlightTicketInfo f")
    int selectTicketCount();

    Page<FlightTicketInfo> findAll(Pageable pageable);


    Page<FlightTicketInfo> findByTicAirlineNameLike(Pageable pageable,String ticAirlineName);


    @Query("select f from FlightTicketInfo f where f.user.userName LIKE %:user_name%")
    Page<FlightTicketInfo> findByUserNameLike(Pageable pageable,String user_name);

    int countByTicAirlineNameLike(String ticAirlineName);

    @Query("select count(*) from FlightTicketInfo f where f.user.userName LIKE %:user_name%")
    int countByUserNameTLike(String user_name);


    @Modifying
    @Transactional
    @Query("delete from FlightTicketInfo f where f.user.userNumber = :user_number")
    void deleteByUserNumber(@Param("user_number")Long user_number);



}
