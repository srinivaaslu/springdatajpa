package com.nivas.example.springdatajpa.repository;

import com.nivas.example.springdatajpa.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone,Long> {
}
