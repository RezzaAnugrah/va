package com.mirae.payment.va.service;

import com.mirae.payment.va.dto.ResponseData;
import com.mirae.payment.va.entity.VirtualAccount;

public interface VAService {
    ResponseData addVA(VirtualAccount request);
}
