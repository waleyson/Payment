package com.accelerex.payment.services;

import com.accelerex.payment.model.request.PaymentRequest;
import com.accelerex.payment.model.response.PaymentResponse;
import org.springframework.stereotype.Service;

public interface PaymentProcessInterface {
     boolean  processPayment(PaymentRequest request);
     PaymentResponse getPayment();
}
