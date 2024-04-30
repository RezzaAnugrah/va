package com.mirae.payment.va.service;

import com.mirae.payment.va.dto.ResponseData;
import com.mirae.payment.va.entity.Transaction;

public interface TransactionService {
    ResponseData addTransaction(Transaction transaction);
    ResponseData getVAHistory();
}
