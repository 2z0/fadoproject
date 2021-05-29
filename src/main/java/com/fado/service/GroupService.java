package com.fado.service;

import com.fado.entitiy.CompanyGroup;
import com.fado.entitiy.CompanySiga;
import com.fado.repository.GroupRepository;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class GroupService {
    @Autowired
    private GroupRepository repo;

    //Company_group table에 있는 모든 group 리턴
    public List<String> listAllGroupName() {
        List<CompanyGroup> groupList = repo.findAll();
        List<String> groupNameList = new ArrayList<>();
        groupList.forEach(group->{
            groupNameList.add(group.getGroup());
        });

        return groupNameList;
    }
}
