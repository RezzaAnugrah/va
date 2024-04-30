package com.mirae.payment.va.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mirae.payment.va.dto.ResponseData;
import com.mirae.payment.va.entity.Promo;
import com.mirae.payment.va.repository.PromoRepository;

@Service
public class PromoServiceImpl implements PromoService {

    @Autowired
    PromoRepository promoRepository;
    
    @Override
    public ResponseData addPromo(Promo request) {
        promoRepository.save(request);
        return new ResponseData(String.valueOf(HttpStatus.OK.value()),"Success", request);
    }

    @Override
    public ResponseData getAllPromo() {
       List<Promo> customers = promoRepository.findAll();
        return new ResponseData(String.valueOf(HttpStatus.OK.value()),"Success", customers);
    }
}