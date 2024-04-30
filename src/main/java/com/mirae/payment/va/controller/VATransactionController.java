package com.mirae.payment.va.controller;

import java.util.Calendar;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirae.payment.va.dto.ResponseData;
import com.mirae.payment.va.dto.VAReqDTO;
import com.mirae.payment.va.dto.VAResDTO;
import com.mirae.payment.va.entity.Promo;
import com.mirae.payment.va.entity.Transaction;
import com.mirae.payment.va.entity.VirtualAccount;
import com.mirae.payment.va.repository.PromoRepository;
import com.mirae.payment.va.service.TransactionService;
import com.mirae.payment.va.service.VAService;

@RestController
@RequestMapping("/transaction")
public class VATransactionController {

    @Autowired
    TransactionService transactionService;
    @Autowired
    PromoRepository promoRepository;
    @Autowired
    VAService vaService;

    @GetMapping (value = {"/report"})
    public ResponseEntity<?> getList(){
        try {
            ResponseData responseData = transactionService.getVAHistory();
            return ResponseEntity.status(HttpStatus.OK.value()).body(responseData);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping (value = {"/create"})
    public ResponseEntity<?> save(@RequestBody VAReqDTO vaReqDTO){
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MINUTE, 15);

            Random random = new Random();
            int length = 12 ;
            StringBuilder sb = new StringBuilder(length);

            for (int i = 0; i < length; i++) {
                int digit = random.nextInt(10); // Generate a random digit (0-9)
                sb.append(digit);
            }
            String vaNo = sb.toString();
            
            // generate  va
            VirtualAccount va = new VirtualAccount();
            va.setCustomerID(vaReqDTO.getCustomerID());
            va.setVirtualAccountNo(vaNo);
            va.setExpirDate(Calendar.getInstance().getTime());
            va.setStatus("Active");
            vaService.addVA(va);
            
            // get promo 
            Promo promo =  promoRepository.findByPromoID(vaReqDTO.getPromotID());
            
            // transaction
            Transaction trx = new Transaction();
            trx.setVirtualAccountID(va.getVirtualAccountID());
            trx.setPromoID(vaReqDTO.getPromotID());
            trx.setAmount(Integer.parseInt(vaReqDTO.getAmount()) - promo.getPromoDiscont());
            trx.setTimestamp(Calendar.getInstance().getTime());
            trx.setStatus("Pending");
            transactionService.addTransaction(trx);
            
            // response
            VAResDTO vaResDTO = new VAResDTO();
            vaResDTO.setAmount(String.valueOf(trx.getAmount()));
            vaResDTO.setVirtualAccountNo(va.getVirtualAccountNo());
            vaResDTO.setBankName(va.getBankName());
            vaResDTO.setExDate(va.getExpirDate());
            
            ResponseData responseData = new ResponseData(String.valueOf(HttpStatus.OK.value()) , "Success", vaResDTO );
            return ResponseEntity.status(HttpStatus.OK.value()).body(responseData);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    
}
