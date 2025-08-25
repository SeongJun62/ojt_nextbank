package com.ojtbank.domain.dao;

import com.ojtbank.common.audit.AuditContext;
import com.ojtbank.common.dto.AuditDto;
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
        AuditDto auditDto = AuditContext.getAudioDto();
        Rcp rcp = new Rcp(auditDto.getOpr_id(), auditDto.getOpr_trm_id(), auditDto.getMng_id(), auditDto.getOrg_id(), LocalDateTime.now(), LocalDateTime.now(), paymentDto.getTrx_seq(), paymentDto.getAcc_no(), LocalDateTime.now(), paymentDto.getAmt(), "payment");
        paymentRepository.save(rcp);
    }

    @Override
    public void updateAccount(PaymentDto paymentDto) {
        paymentRepository.updateAccount(paymentDto.getAmt(), paymentDto.getAcc_no(), LocalDateTime.now());
    }
}
