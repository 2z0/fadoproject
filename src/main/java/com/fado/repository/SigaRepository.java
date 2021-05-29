package com.fado.repository;



import com.fado.entitiy.CompanyInfo;
import com.fado.entitiy.CompanySiga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SigaRepository extends JpaRepository<CompanySiga, String> {
    CompanySiga findByCompany(String name);
}