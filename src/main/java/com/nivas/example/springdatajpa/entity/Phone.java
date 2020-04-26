package com.nivas.example.springdatajpa.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "PHONE")
@Data
public class Phone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String phoneModel;
    private String companyName;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    public Phone() {
    }

    public Phone(String phoneModel, String companyName) {
        this.phoneModel = phoneModel;
        this.companyName = companyName;
//        this.person = person;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", phoneModel='" + phoneModel + '\'' +
                ", companyName='" + companyName + '\'' +
//                ", person=" + person +
                '}';
    }
}
