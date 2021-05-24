package com.fado.service;


import com.fado.entitiy.CompanyInfo;
import com.fado.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CompanyService {
    @Autowired
    private DemoRepository repo;
    //public List<CompanyInfo> listAll(){return repo.findAll();}

    public CompanyInfo getCompanyByCode(String code) {
        return repo.findByCode(code);
    }
}
