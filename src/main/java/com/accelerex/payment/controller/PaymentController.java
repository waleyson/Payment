package com.accelerex.payment.controller;


import com.accelerex.payment.model.data.TransactionDetails;
import com.accelerex.payment.model.request.PaymentRequest;
import com.accelerex.payment.model.response.GetPaymentDetailsReponse;
import com.accelerex.payment.model.response.PaymentResponse;
import com.accelerex.payment.repository.TransactionDetailsRepository;
import com.accelerex.payment.services.*;
import com.accelerex.payment.utils.ValidateCardUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("api")
public class PaymentController {

    @Autowired
    TransactionDetailsRepository transactionDetailsRepository;
    PaymentProcessFacade paymentProcessFacade;

    public PaymentController(PaymentProcessFacade paymentProcessFacade) {
        this.paymentProcessFacade = paymentProcessFacade;
    }

    @RequestMapping(value = "/postpayment", method = RequestMethod.POST)
    public PaymentResponse postPayment(@RequestBody PaymentRequest paymentRequest){
        //todo check for the avaiability of the client ID header and validate the cient ID for accepting the request this should be ddonne inn request intercept..
        PaymentResponse paymentResponse = new PaymentResponse();
        if (ValidateCardUtil.validate(paymentRequest.getCard().getCardNo())){
            paymentResponse = paymentProcessFacade.processPayment(paymentRequest);
        }else {
            paymentResponse.setResponseMessage("E780");
            paymentResponse.setResponseMessage("INVALID CARD NUMBER");
        }
        return paymentResponse;
    }

    @RequestMapping(value ="getpayment", method = RequestMethod.GET)
    public TransactionDetails getPayment(@PathVariable int payId){
        //todo check for the avaiability of the client ID header and validate the cient ID for accepting the request this should be ddonne inn request intercept..

        return transactionDetailsRepository.findByPayId(payId);
    }
}
