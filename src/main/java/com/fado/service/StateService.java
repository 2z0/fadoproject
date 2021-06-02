package com.fado.service;

import com.fado.entitiy.CompanyState;
import com.fado.entitiy.TestEntity;
import com.fado.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {
    @Autowired
    private StateRepository repo;

    public List<CompanyState> listAll() { return repo.findAll();}
    public List<CompanyState> listAllByCode(String code) {return repo.findAllByCode(code);}
}
