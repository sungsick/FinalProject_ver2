package com.kh.myproject.member.manager.repository;

import com.kh.myproject.store.rentcar.model.entity.RentReservationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepositoryM extends JpaRepository<RentReservationInfo, Long> {
}
