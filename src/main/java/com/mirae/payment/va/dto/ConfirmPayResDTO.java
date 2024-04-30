package com.mirae.payment.va.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfirmPayResDTO {
    private String virtualAccountNo;
    private String bankName;
    private String amount;
    private String paymentDate;
    private String remark;
    private String refereceNo;
}