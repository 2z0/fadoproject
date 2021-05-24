package com.fado.repository;



import com.fado.entitiy.CompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoRepository extends JpaRepository<CompanyInfo, String> {
    CompanyInfo findByCode(String code);
}