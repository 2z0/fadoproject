package com.fado.controller;

import com.fado.entitiy.CompanyInfo;
import com.fado.entitiy.FundamentalState;
import com.fado.service.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @Autowired
    FundService fundService;

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
        CompanyInfo info = companyService.getCompanyByCode(code);
        JsonObject json = new JsonObject();

        //GET PBR, PER LINE CHART DATA
        List<FundamentalState> perList = fundService.listAllByCode(code);
        JsonArray jsonPbr = new JsonArray();
        JsonArray jsonPer = new JsonArray();
        perList.forEach(data -> {
            JsonArray jsonPbrData = new JsonArray();
            jsonPbrData.add(data.getDate().toString());
            jsonPbrData.add(data.getPbr());
            jsonPbr.add(jsonPbrData);
        });
        json.add("pbr",jsonPbr);
        json.add("per", jsonPer);

        //GET SPIDER WEB DATA
        List<Double> ratioList = stateService.getSpyderWebData(info.getCorp_code());
        JsonArray jsonSpiderData = new JsonArray();
        for (Double data : ratioList) {
            jsonSpiderData.add(data);
        }
        json.add("spiderData",jsonSpiderData);
        return json.toString();
    }
}
