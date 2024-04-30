package com.mirae.payment.va.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mirae.payment.va.dto.ResponseData;
import com.mirae.payment.va.entity.VirtualAccount;
import com.mirae.payment.va.repository.VARepository;

@Service
public class VAServiceImpl implements VAService {

    @Autowired
    VARepository viruRepository;
    
    @Override
    public ResponseData addVA(VirtualAccount request) {
        viruRepository.save(request);
        return new ResponseData(String.valueOf(HttpStatus.OK.value()),"Success", request);
    }
 
}
