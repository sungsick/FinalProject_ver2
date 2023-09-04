package com.kh.myproject.store.rentcar.repository;



import com.kh.myproject.store.rentcar.model.RentcarInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RentcarRepository extends JpaRepository<RentcarInfoEntity, Long> {



    //차 이름으로 결과검색
    @Query(value="SELECT r FROM RentcarInfoEntity r WHERE r.car_name LIKE %:searchKeyword%")
    List<RentcarInfoEntity> FindByCar_name(@Param("searchKeyword") String searchKeyword);


    //낮은 가격순 정렬
    @Query("SELECT r FROM RentcarInfoEntity r ORDER BY r.car_discount DESC")
    List<RentcarInfoEntity> FindDiscountDesc();


    //렌트카리스트 정렬
    @Query("SELECT r FROM RentcarInfoEntity r")
    List<RentcarInfoEntity> FindAll();


}