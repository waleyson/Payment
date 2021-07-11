package com.accelerex.payment.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetPaymentDetailsReponse {
    private String cardHolderName;
    private long cardNo;
    private String expiryDate;
    private String cvv;
    private Long payId;
    private BigDecimal amount;
    private String type ;
    private Long buyerId;
    private String name;
    private String email;
    private String status;
}
