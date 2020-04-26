package com.nivas.example.springdatajpa.repository;

import com.nivas.example.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
