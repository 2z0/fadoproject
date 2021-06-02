package com.fado.repository;

import com.fado.entitiy.CompanyGroup;
import com.fado.entitiy.FundamentalState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FundRepository extends JpaRepository<FundamentalState, String> {
    List<FundamentalState> findAllByCode(String code);
}
