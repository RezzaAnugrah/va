package com.mirae.payment.va.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirae.payment.va.entity.Promo;

public interface PromoRepository extends JpaRepository<Promo, String>{
    Promo findByPromoID(String promoCode);

}
