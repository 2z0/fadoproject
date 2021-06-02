package com.fado.controller;

import com.fado.service.CompanyService;
import com.fado.service.GroupService;
import com.fado.service.SigaService;
import com.fado.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GroupController {
    @Autowired
    CompanyService companyService;
    @Autowired
    SigaService sigaService;
    @Autowired
    GroupService groupService;

    @GetMapping("/group")
    public String viewGroupPage(){
        return "group";
    }
}
