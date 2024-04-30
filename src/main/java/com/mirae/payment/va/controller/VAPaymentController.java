package com.mirae.payment.va.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirae.payment.va.dto.ConfirmPayReqDTO;
import com.mirae.payment.va.dto.ConfirmPayResDTO;
import com.mirae.payment.va.dto.ResponseData;
import com.mirae.payment.va.entity.Payment;
import com.mirae.payment.va.entity.Transaction;
import com.mirae.payment.va.entity.VirtualAccount;
import com.mirae.payment.va.repository.TransactionRepository;
import com.mirae.payment.va.repository.VARepository;
import com.mirae.payment.va.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class VAPaymentController {

    @Autowired
    PaymentService paymentService;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    VARepository vaRepository;

    @GetMapping (value = {"/report"})
    public ResponseEntity<?> getList(){
        try {
            ResponseData responseData = paymentService.getHistoryPayment();
            return ResponseEntity.status(HttpStatus.OK.value()).body(responseData);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping (value = {"/confirm"})
    public ResponseEntity<?> save(@RequestBody ConfirmPayReqDTO confirmPayReqDTO){
        try {

            VirtualAccount va = vaRepository.findByVirtualAccountNo(confirmPayReqDTO.getVirtualAccountNo());
            Transaction trx = transactionRepository.findByVirtualAccountID(va.getVirtualAccountID());
            
            // confirm
            Payment payment = new Payment();
            payment.setRefereceNo(UUID.randomUUID().toString().replace("-", "").substring(0, 12));
            payment.setTransactionID(trx.getTransactionID());
            payment.setMetodeType("VA");
            paymentService.pay(payment);

            // transactionRepository
            trx.setStatus("Paid");
            transactionRepository.save(trx);
            // response
            ConfirmPayResDTO confirmPayResDTO = new ConfirmPayResDTO();
            confirmPayResDTO.setVirtualAccountNo(confirmPayReqDTO.getVirtualAccountNo());
            confirmPayResDTO.setBankName(va.getBankName());
            confirmPayResDTO.setAmount(confirmPayReqDTO.getAmount());
            confirmPayResDTO.setPaymentDate(confirmPayReqDTO.getPaymentDate());
            confirmPayResDTO.setRemark(confirmPayReqDTO.getRemark());
            confirmPayResDTO.setRefereceNo(payment.getRefereceNo());

            ResponseData responseData = new ResponseData(String.valueOf(HttpStatus.OK.value()) , "Success", confirmPayResDTO );
            return ResponseEntity.status(HttpStatus.OK.value()).body(responseData);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    
}
