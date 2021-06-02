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
@Table(name = "corp_fundamental_statement")
public class FundamentalState {
    @Id
    @Column(name="stock_code")
    String code;
    @Column(name="per")
    double per;
    @Column(name="pbr")
    double pbr;

    public FundamentalState(String code, int per, int pbr) {
        this.code = code;
        this.per = per;
        this.pbr = pbr;
    }
}
