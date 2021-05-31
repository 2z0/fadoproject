package com.fado.service;


import com.fado.entitiy.CompanyInfo;
import com.fado.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class CompanyService {
    @Autowired
    private CompanyRepository repo;

    public CompanyInfo getCompanyByCode(String code) {
        return repo.findByCode(code);
    }
    public CompanyInfo getCompanyByName(String name) {
        return repo.findByCompany(name);
    }
    public List<CompanyInfo> listAll() { return repo.findAll();}
    public List<CompanyInfo> getCompanyGroup(String group) {
        return repo.findByGroup(group);
    }
    public List<String> getAllCompanyName(){
        List<CompanyInfo> infos = repo.findAll();
        List<String> result = new ArrayList<>();
        infos.forEach(info -> {
            result.add(info.getCompany());
        });
        return result;
    }
}
