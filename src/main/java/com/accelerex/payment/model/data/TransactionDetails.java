package com.accelerex.payment.model.data;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Builder
@Data

public class TransactionDetails {
    @Id
    private Long payId;
    private String cardHolderName;
    private long cardNo;
    private String expiryDate;
    private String cvv;
    private BigDecimal amount;
    private String type ;
    private Long buyerId;
    private String name;
    private String email;
    private String status;
}
