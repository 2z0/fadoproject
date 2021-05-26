package com.fado.entitiy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "company_info")
public class CompanyInfo {

    @Id
    private String code;
    private String company;
    private String group;

    public CompanyInfo(String code, String company,String group){
        this.code = code;
        this.company = company;
        this.group = group;
    }
}
