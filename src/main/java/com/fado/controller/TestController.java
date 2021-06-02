package com.fado.controller;

import com.fado.entitiy.TestEntity;
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

    @RequestMapping("/list")
    public String showCompanyChart(Model model){

        List<String> groupNameList = groupService.listAllGroupName();
        model.addAttribute("groupNameList",groupNameList);
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
