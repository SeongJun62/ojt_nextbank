package com.ojtbank.domain.dao;

import com.ojtbank.common.dto.PaymentDto;

public interface PaymentDao {

    void payment(PaymentDto paymentDto);
    void updateAccount(PaymentDto paymentDto);
}
