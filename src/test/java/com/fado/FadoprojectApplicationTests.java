package com.fado;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class FadoprojectApplicationTests {
//    @Autowired
//    private DemoRepository demoRepository;
//    @Test
//    void contextLoads() {
//        CompanyInfo companyInfo = demoRepository.findByCode("000020");
//        assertEquals("000020", companyInfo.getCode());
//    }

}
