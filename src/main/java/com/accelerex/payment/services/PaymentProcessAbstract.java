package com.accelerex.payment.services;

import com.accelerex.payment.model.request.PaymentRequest;
import com.accelerex.payment.model.response.PaymentResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class PaymentProcessAbstract implements PaymentProcessInterface {
    PaymentResponse paymentResponse;

    @Override
    public PaymentResponse getPayment() {
        log.info("RESPONSE INABSTRACT {}",paymentResponse);
        return paymentResponse;
    }
}
