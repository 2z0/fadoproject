package com.fado.service;

import com.fado.entitiy.CompanyInfo;
import com.fado.entitiy.InvestarMove;
import com.fado.repository.MoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class MoveService {
    @Autowired
    public MoveRepository repo;
    public List<InvestarMove> listAll() { return repo.findAll();}

    public InvestarMove getMoveByAgen(long agen) {return repo.findByAgen(agen);}
    public InvestarMove getMoveByFore(long fore) {return repo.findByFore(fore);}
}
