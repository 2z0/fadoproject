package com.fado.entitiy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "corp_fundamental_statement")
public class FundamentalState {
    @Id
    private int id;
    @Column(name="stock_code")
    private String code;
    @Column(name="date")
    private Date date;
    @Column(name="per")
    private double per;
    @Column(name="pbr")
    private double pbr;

    public FundamentalState(String code, Date date, double per, double pbr) {
        this.code = code;
        this.date = date;
        this.per = per;
        this.pbr = pbr;
    }
}
