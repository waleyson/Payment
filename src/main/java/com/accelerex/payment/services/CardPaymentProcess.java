package com.accelerex.payment.services;

import com.accelerex.payment.model.request.PaymentRequest;
import com.accelerex.payment.model.response.PaymentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Slf4j
//@Qualifier("Card")
public class CardPaymentProcess extends PaymentProcessAbstract {
    @Autowired
    SaveTransToDBImpl saveTransToDB;
    @Override
    public boolean processPayment(PaymentRequest request) {
        log.info("EXECUTING CARD {}", request);
        log.info("the request is "+ request.getPayment().getType());
        boolean isProcessed = false;
        if (request.getPayment().getType().equalsIgnoreCase("Card")){
            isProcessed = true;
            try{
                processCardPayment(request);
            }catch (Exception ex){
                log.error("ERROR OCCURED {}", ex.fillInStackTrace());
                paymentResponse.setResponsCode("E01");
                paymentResponse.setResponseMessage("ERROR");
            }
        }
        saveTransToDB.saveTransactionInfo(request, paymentResponse);
        return isProcessed;
    }

    private PaymentResponse processCardPayment(PaymentRequest request) {
        //proceess the USSD paymennt inntegration
        paymentResponse = new PaymentResponse();
        paymentResponse.setResponsCode("999");
        paymentResponse.setResponseMessage("SUCCESSFUL");
        return paymentResponse;
    }
}
