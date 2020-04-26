package com.nivas.example.springdatajpa.repository;

import com.nivas.example.springdatajpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
