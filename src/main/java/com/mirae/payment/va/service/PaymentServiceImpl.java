package com.mirae.payment.va.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mirae.payment.va.dto.ResponseData;
import com.mirae.payment.va.entity.Payment;
import com.mirae.payment.va.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public ResponseData pay(Payment request) {
        paymentRepository.save(request);
        return new ResponseData(String.valueOf(HttpStatus.OK.value()),"Success", request);
    }

    @Override
    public ResponseData getHistoryPayment() {
        List<Payment> payments =  paymentRepository.findAll();
        return new ResponseData(String.valueOf(HttpStatus.OK.value()),"Success", payments);
    }
    
}
