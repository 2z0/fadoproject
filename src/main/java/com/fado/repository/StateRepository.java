package com.fado.repository;

import com.fado.entitiy.CompanyGroup;
import com.fado.entitiy.CompanyState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepository extends JpaRepository<CompanyState, String> {
    List<CompanyState> findAllByCode(String code);
}