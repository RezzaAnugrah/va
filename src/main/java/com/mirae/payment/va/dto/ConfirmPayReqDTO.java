package com.mirae.payment.va.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfirmPayReqDTO {
    private String virtualAccountNo;
    private String amount;
    private String paymentDate;
    private String remark;
}