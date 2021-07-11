package com.accelerex.payment.model.data;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@Entity
public class Card {


    private String cardHolderName;
    private long cardNo;
    private String expiryDate;
    private String cvv;
}
