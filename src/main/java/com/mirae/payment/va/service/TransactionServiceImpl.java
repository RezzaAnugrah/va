package com.mirae.payment.va.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mirae.payment.va.dto.ResponseData;
import com.mirae.payment.va.entity.Transaction;
import com.mirae.payment.va.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public ResponseData addTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
        return new ResponseData(String.valueOf(HttpStatus.OK.value()),"Success", transaction);
    }

    @Override
    public ResponseData getVAHistory() {
        List<Transaction> transaction =  transactionRepository.findAll();
        return new ResponseData(String.valueOf(HttpStatus.OK.value()),"Success", transaction);
    }   
}
