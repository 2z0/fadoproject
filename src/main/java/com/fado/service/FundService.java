package com.fado.service;

import com.fado.entitiy.CompanyState;
import com.fado.entitiy.FundamentalState;
import com.fado.repository.FundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FundService {
    @Autowired
    FundRepository repo;
    public List<FundamentalState> listAllByCode(String code) {return repo.findAllByCode(code);}
}
