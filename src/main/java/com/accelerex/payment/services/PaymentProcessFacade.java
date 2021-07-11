package com.accelerex.payment.services;

import com.accelerex.payment.model.request.PaymentRequest;
import com.accelerex.payment.model.response.PaymentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PaymentProcessFacade {
    @Autowired
    List<PaymentProcessInterface> paymentProcessInterfaceList;

    public PaymentResponse processPayment(PaymentRequest paymentRequest){
        PaymentProcessInterface paymentProcessInterface = paymentProcessInterfaceList.stream()
                .filter(x -> x.processPayment(paymentRequest)).findFirst().orElseThrow(() -> new IllegalArgumentException("Not payment type is dictected !!!"));
        log.info("the response in FACADE {}",paymentProcessInterface.getPayment());
        return paymentProcessInterface.getPayment();
    }

}
