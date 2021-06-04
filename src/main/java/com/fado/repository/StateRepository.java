package com.fado.repository;

import com.fado.entitiy.CompanyGroup;
import com.fado.entitiy.CompanyInfo;
import com.fado.entitiy.CompanyState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StateRepository extends JpaRepository<CompanyState, String> {
    @Query(value="SELECT * from corp_financial_statement where corp_code=?1 order by bsns_year desc, field(reprt_code,\"00100\",\"11014\",\"11012\",\"11013\") LIMIT 1", nativeQuery = true)
    CompanyState findRecentData(String code);

    List<CompanyState> findAllByCode(String code);
}

