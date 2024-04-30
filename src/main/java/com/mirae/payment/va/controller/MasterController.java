package com.mirae.payment.va.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirae.payment.va.dto.ResponseData;
import com.mirae.payment.va.service.CustomerService;
import com.mirae.payment.va.service.PromoService;

@RestController
@RequestMapping("/list")
public class MasterController {

    @Autowired
    CustomerService customerService;

    @Autowired
    PromoService promoService;

    @GetMapping (value = {"/customer"})
    public ResponseEntity<?> getCustomer(){
        try {
            ResponseData responseData = customerService.getAllCustomers();
            return ResponseEntity.status(HttpStatus.OK.value()).body(responseData);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping (value = {"/promo"})
    public ResponseEntity<?> getPromo(){
        try {
            ResponseData responseData = promoService.getAllPromo();
            return ResponseEntity.status(HttpStatus.OK.value()).body(responseData);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    
}
