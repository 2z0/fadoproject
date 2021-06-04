package com.fado.controller;

import com.fado.entitiy.FundamentalState;
import com.fado.entitiy.TestEntity;
import com.fado.service.FundService;
import com.fado.service.GroupService;
import com.fado.service.TestService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    TestService testService;
    @Autowired
    GroupService groupService;
    @Autowired
    FundService fundService;
    @RequestMapping("/list")
    public String showCompanyChart(Model model){

        List<FundamentalState> List = fundService.listAllByCode("005930");
        model.addAttribute("List",List);
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
