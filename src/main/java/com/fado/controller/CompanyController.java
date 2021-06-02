package com.fado.controller;

import com.fado.entitiy.CompanyInfo;
import com.fado.entitiy.CompanyState;
import com.fado.entitiy.TestEntity;
import com.fado.service.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class CompanyController {
    @Autowired
    CompanyService companyService;
    @Autowired
    SigaService sigaService;
    @Autowired
    GroupService groupService;
    @Autowired
    StateService stateService;

    @GetMapping("/search")
    public String viewChartPage(@ModelAttribute("companyInfo") CompanyInfo info, Model model) {
        CompanyInfo companyInfo = companyService.getCompanyByName(info.getCompany());
        model.addAttribute("companyInfo", companyInfo);
        return "charts";
    }

    @GetMapping("/search/{name}")
    public String viewChartPage2(@PathVariable(name = "name") String name, Model model) {
        CompanyInfo companyInfo = companyService.getCompanyByName(name);
        model.addAttribute("companyInfo", companyInfo);
        return "charts";
    }

    @GetMapping("/dataSend/{code}")
    @ResponseBody
    public String setChartData(@PathVariable(name = "code") String code) {
        CompanyInfo companyInfo = companyService.getCompanyByCode(code);
        return code;
    }
}