package com.mirae.payment.va.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mirae.payment.va.dto.ResponseData;
import com.mirae.payment.va.entity.Customer;
import com.mirae.payment.va.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    
    @Override
    public ResponseData addCustomer(Customer request) {
        customerRepository.save(request);
        return new ResponseData(String.valueOf(HttpStatus.OK.value()),"Success", request);
    }

    @Override
    public ResponseData getAllCustomers() {
        List<Customer> customers =  customerRepository.findAll();
        return new ResponseData(String.valueOf(HttpStatus.OK.value()),"Success", customers);
    }
}
