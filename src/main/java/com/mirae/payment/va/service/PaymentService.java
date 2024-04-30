package com.mirae.payment.va.service;

import com.mirae.payment.va.dto.ResponseData;
import com.mirae.payment.va.entity.Payment;

public interface PaymentService {
    ResponseData pay(Payment payment);
    ResponseData getHistoryPayment();
}
