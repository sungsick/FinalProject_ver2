package com.kh.myproject.store.rentcar.repository;


import com.kh.myproject.store.rentcar.model.RentcarComEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentcarComRepository extends JpaRepository<RentcarComEntity, Long>{



}
