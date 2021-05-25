package com.fado.service;

import com.fado.entitiy.CompanyInfo;
import com.fado.entitiy.DailyPrice;
import com.fado.repository.DemoRepository;
import com.fado.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class PriceService {
    @Autowired
    private PriceRepository repo;
    public List<DailyPrice> listAll() { return repo.findAll();}
}
