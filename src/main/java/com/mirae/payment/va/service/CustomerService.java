package com.mirae.payment.va.service;

import com.mirae.payment.va.dto.ResponseData;
import com.mirae.payment.va.entity.Customer;

public interface CustomerService {
    ResponseData addCustomer(Customer request);
    ResponseData getAllCustomers();
}
