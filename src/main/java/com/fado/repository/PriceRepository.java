package com.fado.repository;



import com.fado.entitiy.CompanyInfo;
import com.fado.entitiy.DailyPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<DailyPrice, String> {

}