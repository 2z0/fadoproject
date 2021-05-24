package com.fado.service;


import com.fado.entitiy.CompanyInfo;
import com.fado.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CompanyService {
    @Autowired
    private DemoRepository repo;

    public CompanyInfo getCompanyByCode(String code) {
        return repo.findByCode(code);
    }
    public CompanyInfo getCompanyByName(String name) {
        return repo.findByCode(name);
    }
    public List<CompanyInfo> listAll() { return repo.findAll();}
}
