package com.ojtbank.domain.dao;

import com.ojtbank.common.dto.PaymentDto;
import com.ojtbank.domain.model.Rcp;
import com.ojtbank.domain.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;


public class PaymentJpaDaoImpl implements PaymentDao{

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentJpaDaoImpl(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void payment(PaymentDto paymentDto) {
        Rcp rcp = new Rcp(paymentDto.getTrx_seq(), paymentDto.getAcc_no(), LocalDateTime.now(), paymentDto.getAmt(), "payment");
        paymentRepository.save(rcp);
    }

    @Override
    public void updateAccount(PaymentDto paymentDto) {
        paymentRepository.updateAccount(paymentDto.getAmt(), paymentDto.getAcc_no());
    }
}
