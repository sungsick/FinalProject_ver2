package com.kh.myproject.store.flight.repository;

import com.kh.myproject.store.flight.model.entity.TicketInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightTicketRepository extends JpaRepository<TicketInfo, Long> {
    List<TicketInfo> findByUser_UserNumber(Long userNumber);
}
