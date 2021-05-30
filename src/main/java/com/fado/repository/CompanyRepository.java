package com.fado.repository;



import com.fado.entitiy.CompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<CompanyInfo, String> {
    @Query(value="SELECT * from company_info where company_info.corp_group=?1 order by RAND() LIMIT 5", nativeQuery = true)
    List<CompanyInfo> findByGroup(String group);
    CompanyInfo findByCode(String code);
}