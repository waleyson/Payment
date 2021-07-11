package com.accelerex.payment.services;

import com.accelerex.payment.model.data.TransactionDetails;
import com.accelerex.payment.model.request.PaymentRequest;
import com.accelerex.payment.model.response.PaymentResponse;
import com.accelerex.payment.repository.TransactionDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SaveTransToDBImpl {
    @Autowired
    TransactionDetailsRepository transactionDetailsRepository;

    public void saveTransactionInfo(PaymentRequest request, PaymentResponse response){
        TransactionDetails transactionDetails = TransactionDetails.builder()
                .amount(request.getPayment().getAmount())
                .buyerId(request.getBuyer().getId())
                .cardHolderName(request.getCard().getCardHolderName())
                .cardNo(request.getCard().getCardNo()) // PCIDSS comply must be enforced
                .cvv(request.getCard().getCvv()) // PCIDSS comply must be enforced
                .email(request.getBuyer().getEmail())
                .expiryDate(request.getCard().getExpiryDate())
                .name(request.getBuyer().getName())
                .payId(request.getPayment().getId())
                .status(response.getResponseMessage())
                .build();
        transactionDetailsRepository.save(transactionDetails);
    }
}
