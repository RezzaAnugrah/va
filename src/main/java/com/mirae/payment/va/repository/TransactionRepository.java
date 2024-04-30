package com.mirae.payment.va.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirae.payment.va.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
    Transaction findByVirtualAccountID(Integer vaID);
}
