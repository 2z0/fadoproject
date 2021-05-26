package com.fado.service;

import com.fado.entitiy.CompanySiga;
import com.fado.repository.SigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SigaService {
    @Autowired
    private SigaRepository repo;
    public List<CompanySiga> listAll() { return repo.findAll();}
    public CompanySiga getSigaByName(String name){return repo.findByCompany(name);}
}
