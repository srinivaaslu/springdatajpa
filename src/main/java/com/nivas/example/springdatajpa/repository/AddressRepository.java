package com.nivas.example.springdatajpa.repository;

import com.nivas.example.springdatajpa.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
