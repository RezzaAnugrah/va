package com.mirae.payment.va.entity;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VirtualAccount {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer VirtualAccountID;
    private String customerID;
    private String virtualAccountNo;
    private String bankName = "BCA";
    private String status;
    private Date expirDate;
}
