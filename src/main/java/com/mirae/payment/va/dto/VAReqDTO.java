package com.mirae.payment.va.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VAReqDTO {
    private String customerID;
    private String customerName;
    private String amount;
    private String promotID;
}