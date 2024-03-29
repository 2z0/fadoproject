package com.fado.controller;

import com.fado.entitiy.CompanyInfo;
import com.fado.entitiy.CompanySiga;
import com.fado.entitiy.InvestarMove;
import com.fado.entitiy.TestEntity;
import com.fado.service.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {
    @Autowired
    CompanyService companyService;

    @Autowired
    SigaService sigaService;
    @Autowired
    GroupService groupService;
    @Autowired
    TestService testService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        return "index";
    }

    @RequestMapping("/circlepacking")
    @ResponseBody
    public String getDataForCirclePacking() {
        List<String> groupNameList = groupService.listAllGroupName();
        JsonObject json = new JsonObject();
        JsonArray jsonArray = new JsonArray();

        groupNameList.forEach(groupName -> {
            List<CompanyInfo> companyList = new ArrayList<>();
            JsonArray jsonGroupData = new JsonArray();
            JsonObject jsonGroup = new JsonObject();
            companyList=companyService.getCompanyGroup(groupName);
            companyList.forEach(company->{
                CompanySiga companySiga = sigaService.getSigaByName(company.getCompany());
                JsonObject jsonCompany = new JsonObject();
                jsonCompany.addProperty("name",companySiga.getCompany());
                jsonCompany.addProperty("value",companySiga.getSiga()/1000000000);
                jsonGroupData.add(jsonCompany);
            });
            jsonGroup.addProperty("name",groupName);
            jsonGroup.add("data",jsonGroupData);
            jsonArray.add(jsonGroup);
        });

        json.add("circlePacking",jsonArray);
        return json.toString();
    }

    @RequestMapping("/charts/{code}")
    public String viewCompanyChart(@PathVariable String code, Model model){
        CompanyInfo companyInfo = companyService.getCompanyByCode(code);
        JsonArray jsonGroup = new JsonArray();
        JsonObject jsonCompany = new JsonObject();
        JsonObject json = new JsonObject();

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
    public String getDataFromDB() { //db 접근 역할
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

    @RequestMapping("/move")
    @ResponseBody
    public String getInvestarMove() {
        List<InvestarMove> moveList= MoveService.listAll();
        JsonArray jsonAgen = new JsonArray();
        JsonArray jsonFore = new JsonArray();

        JsonObject json = new JsonObject();
        moveList.forEach(move ->{
            jsonFore.add(move.getFore());
            jsonAgen.add(move.getAgen());
        });

        json.add("fore",jsonFore);
        json.add("agen",jsonAgen);
        return json.toString();
    }



}
