package com.accelerex.payment.repository;

import com.accelerex.payment.model.data.TransactionDetails;
import org.springframework.data.repository.CrudRepository;

public interface TransactionDetailsRepository extends CrudRepository<TransactionDetails, String> {
    TransactionDetails findByPayId(String payId);
}
