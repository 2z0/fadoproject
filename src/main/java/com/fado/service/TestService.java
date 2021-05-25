package com.fado.service;

import com.fado.entitiy.DailyPrice;
import com.fado.entitiy.TestEntity;
import com.fado.repository.PriceRepository;
import com.fado.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class TestService {
    @Autowired
    private TestRepository repo;
    public List<TestEntity> listAll() { return repo.findAll();}
}
