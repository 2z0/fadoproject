package com.fado;

import com.fado.entitiy.CompanyInfo;
import com.fado.repository.DemoRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class FadoprojectApplicationTests {
    @Autowired
    private DemoRepository demoRepository;
    @Test
    void contextLoads() {
        CompanyInfo companyInfo = demoRepository.findByCode("000020");
        assertEquals("000020", companyInfo.getCode());
    }

}
