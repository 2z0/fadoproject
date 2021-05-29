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
@Table(name = "investar_move")
public class InvestarMove {

    @Id
    private String code;
    private String company;
    @Column(name = "foreign_20210528")
    private long fore;
    @Column(name = "agency_20210528")
    private long agen;

    public InvestarMove(String code, String company,long fore, long agen){
        this.code = code;
        this.company = company;
        this.fore = fore;
        this.agen = agen;
    }
}
