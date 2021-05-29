package com.fado.entitiy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "company_group")
public class CompanyGroup {
    @Id
    private int id;
    private String group;

    public CompanyGroup(int id, String group) {
        this.id = id;
        this.group = group;
    }
}
