package com.fado.service;

import com.fado.entitiy.CompanyState;
import com.fado.entitiy.TestEntity;
import com.fado.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StateService {
    @Autowired
    private StateRepository repo;

    public List<CompanyState> listAll() { return repo.findAll();}
    public List<CompanyState> listAllByCode(String code) {return repo.findAllByCode(code);}
    public List<Double> getSpyderWebData(String code){
        CompanyState state = repo.findRecentData(code);
        long tl = state.getTotal_liabilities(); //부채총계
        long te = state.getTotal_equity();  //자본총계
        long ca = state.getCurrent_assets();    //유동자산
        long cl = state.getCurrent_liabilities();   //유동부채
        long nca = state.getNon_current_assets();   //비유동자산

        double debtRatio = Math.round((double)tl/te*100); //부채비율
        double currentRatio = Math.round((double)ca/cl*100);    //유동비율
        double nonCurrentRatio = Math.round((double)nca/te*100);    //비유동비율
        double equityRatio = Math.round((double)te/(te+tl)*100);    //자기자본비율
        double workingCapital = Math.round((double)(ca-cl)/(te+tl)*100);    //순운전자본 대 총자본

        List<Double> result = new ArrayList<>();
        result.add(workingCapital);
        result.add(debtRatio);
        result.add(currentRatio);
        result.add(nonCurrentRatio);
        result.add(equityRatio);

        return result;
    }

    public HashMap<String, Long> getSalesWebData(String code) {
        CompanyState state = repo.findRecentData(code);
        long ni = state.getNet_income();    //당기순이익
        long oi = state.getOperating_income();  //영업이익
        long sales = state.getSales();  //매출액
        HashMap<String, Long> result = new HashMap<String, Long>();
        result.put("sales",sales);
        result.put("ni",ni);
        result.put("oi",oi);

        return result;
    }
}
