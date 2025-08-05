package com.ojtbank.domain.dao;

import com.ojtbank.common.dto.PaymentDto;
import com.ojtbank.domain.mapper.PaymentMapper;
import com.ojtbank.domain.model.Rcp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(name = "dao.impl-type", havingValue = "mybatis")
public class PaymentMyBatisDaoImpl implements PaymentDao{

    private final PaymentMapper paymentMapper;

    @Autowired
    public PaymentMyBatisDaoImpl(PaymentMapper paymentMapper) {
        this.paymentMapper = paymentMapper;
    }

    @Override
    public void payment(PaymentDto paymentDto) {
        Rcp rcp = new Rcp(paymentDto.getTrx_seq(), paymentDto.getAcc_no(), paymentDto.getTrx_datetime(), paymentDto.getAmt(), paymentDto.getTrx_type());
        paymentMapper.insertPayment(rcp);
    }

    @Override
    public void updateAccount(PaymentDto paymentDto) {
        Rcp rcp = new Rcp(paymentDto.getTrx_seq(), paymentDto.getAcc_no(), paymentDto.getTrx_datetime(), paymentDto.getAmt(), paymentDto.getTrx_type());
        paymentMapper.updateAccount(rcp);
    }
}
