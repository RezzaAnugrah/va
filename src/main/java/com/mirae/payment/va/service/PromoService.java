package com.mirae.payment.va.service;

import com.mirae.payment.va.dto.ResponseData;
import com.mirae.payment.va.entity.Promo;

public interface PromoService {
    ResponseData addPromo(Promo request);
    ResponseData getAllPromo();
}
