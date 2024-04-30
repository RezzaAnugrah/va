package com.mirae.payment.va.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirae.payment.va.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{
    
}
