package com.ojtbank.api.service;

import com.ojtbank.common.dto.PaymentDto;
import com.ojtbank.domain.dao.PaymentDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    private final PaymentDao paymentDao;

    public PaymentServiceImpl(PaymentDao paymentDao){
        this.paymentDao = paymentDao;
    }


    @Override
    public void payment(PaymentDto paymentDto) {
        paymentDao.payment(paymentDto);
        paymentDao.updateAccount(paymentDto);
    }
}
