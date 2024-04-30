package com.mirae.payment.va.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirae.payment.va.entity.VirtualAccount;

public interface VARepository extends JpaRepository<VirtualAccount, Integer>{
    VirtualAccount findByVirtualAccountNo(String vaNo);
}
