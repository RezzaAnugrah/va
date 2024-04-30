package com.mirae.payment.va.dto;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VAResDTO {

    private String virtualAccountNo;
    private String bankName;
    private String amount;
    private Date exDate;
}