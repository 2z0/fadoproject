package com.fado.entitiy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "corp_financial_statement")
public class CompanyState {
    @Id
    @Column(name="corp_code")
    String code;

    String reprt_code;
    int bsns_year;
    long sales;
    long operating_income;
    long net_income;
    long total_equity;
    long total_liabilities;
    long current_assets;
    long current_liabilities;
    long non_current_assets;

    public CompanyState(String code, String reprt_code, int bsns_year, long sales, long operating_income, long net_income, long total_equity, long total_liabilities, long current_assets, long current_liabilities, long non_current_assets) {
        this.code = code;
        this.reprt_code = reprt_code;
        this.bsns_year = bsns_year;
        this.sales = sales;
        this.operating_income = operating_income;
        this.net_income = net_income;
        this.total_equity = total_equity;
        this.total_liabilities = total_liabilities;
        this.current_assets = current_assets;
        this.current_liabilities = current_liabilities;
        this.non_current_assets = non_current_assets;
    }
}
