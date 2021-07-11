package com.accelerex.payment.model.request;

import com.accelerex.payment.model.data.Buyer;
import com.accelerex.payment.model.data.Card;
import com.accelerex.payment.model.data.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {
    private Buyer buyer;
    private Payment payment;
    private Card card;
}
