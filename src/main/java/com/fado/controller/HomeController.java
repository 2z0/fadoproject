package com.fado.controller;

import com.fado.entitiy.CompanyInfo;
import com.fado.entitiy.DailyPrice;
import com.fado.entitiy.TestEntity;
import com.fado.service.CompanyService;
import com.fado.service.PriceService;
import com.fado.service.TestService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class HomeController {
    @Autowired
    CompanyService companyService;

    @Autowired
    PriceService priceService;

    @Autowired
    TestService testService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        return "index";
    }

    @RequestMapping("/charts/{code}")
    public String viewCompanyChart(@PathVariable String code, Model model){
        CompanyInfo companyInfo = companyService.getCompanyByCode(code);
        model.addAttribute("companyInfo",companyInfo);
        return "charts";
    }

    @GetMapping("/group")
    public String viewGroupPage(){
        return "group";
    }




    //EXAMPLE
    @RequestMapping("/list")
    public String showCompanyChart(Model model){
        List<TestEntity> testData = testService.listAll();
        model.addAttribute("testData",testData);
        return "list";
    }

    @RequestMapping("/test")
    public String viewTestPage(){
        return "test";
    }

    @RequestMapping("/chartdata")
    @ResponseBody
    public String getDataFromDB() {
        List<TestEntity> testList = testService.listAll();
        JsonArray jsonCompany = new JsonArray();
        JsonArray jsonVolume = new JsonArray();

        JsonObject json = new JsonObject();
        testList.forEach(test -> {
            jsonCompany.add(test.getCompany());
            jsonVolume.add(test.getVolume());
        });

        json.add("cp",jsonCompany);
        json.add("vm",jsonVolume);
        return json.toString();
    }
}
