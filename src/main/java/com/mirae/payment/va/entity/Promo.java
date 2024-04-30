package com.mirae.payment.va.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Promo {
    
    @Id
    private String promoID;
    private String promoName;
    private Integer promoDiscont;
}
