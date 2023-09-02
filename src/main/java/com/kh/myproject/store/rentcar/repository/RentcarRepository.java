package com.kh.myproject.store.rentcar.repository;


import com.kh.myproject.store.rentcar.model.RentcarInfoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentcarRepository extends JpaRepository<RentcarInfoDTO, Long> {


}
