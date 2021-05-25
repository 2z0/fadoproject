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
@Table(name = "test")
public class TestEntity {
    @Id
    String company;
    long volume;

    public TestEntity(String company, long volume) {
        this.company = company;
        this.volume = volume;
    }
}
