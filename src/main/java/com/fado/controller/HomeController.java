package com.fado.controller;

import com.fado.entitiy.CompanyInfo;
import com.fado.entitiy.CompanySiga;
import com.fado.service.CompanyService;
import com.fado.service.GroupService;
import com.fado.service.SigaService;
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


    @GetMapping("/")
    public String viewHomePage(Model model){
        CompanyInfo info = new CompanyInfo();
        model.addAttribute("info", info);
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

    @RequestMapping("/autoComplete")
    @ResponseBody
    public List<String> getCompanyNameList() {
        return companyService.getAllCompanyName();
    }
}
