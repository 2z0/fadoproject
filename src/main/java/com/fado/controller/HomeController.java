package com.fado.controller;

import com.fado.entitiy.CompanyInfo;
import com.fado.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
    @Autowired
    CompanyService companyService;

    @GetMapping("/")
    public String sayHello(){
        return "index";
    }

    @RequestMapping("/charts/{code}")
    public String showCompanyChart(@PathVariable String code, Model model){
        CompanyInfo companyInfo = companyService.getCompanyByCode(code);
        model.addAttribute("companyInfo",companyInfo);
        return "charts";
    }

    @GetMapping("/group")
    public String goToGroup(){
        return "group";
    }
}
