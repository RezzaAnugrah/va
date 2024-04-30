package com.mirae.payment.va.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirae.payment.va.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{
    
}
