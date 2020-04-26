package com.nivas.example.springdatajpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PERSON")
@Data
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String location;
    @OneToMany(mappedBy = "person",
            cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Phone> phones =new ArrayList<>();;

    public Person() {
    }

    public Person(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public void addPhone(Phone phone){
        phones.add(phone);
        phone.setPerson(this);

    }

//    @Override
//    public String toString() {
//        return "Person{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", location='" + location + '\'' +
//                ", phones=" + phones +
//                '}';
//    }
}
