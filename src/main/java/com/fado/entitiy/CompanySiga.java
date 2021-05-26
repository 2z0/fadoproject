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
@Table(name = "company_siga")
public class CompanySiga {

    @Id
    String code;
    String company;
    long price;
    long siga;

    public CompanySiga(String code, String company, long price, long siga) {
        this.code = code;
        this.company = company;
        this.price = price;
        this.siga = siga;
    }
}
