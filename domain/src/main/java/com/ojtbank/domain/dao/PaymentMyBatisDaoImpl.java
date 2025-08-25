package com.ojtbank.domain.dao;

import com.ojtbank.common.audit.AuditContext;
import com.ojtbank.common.dto.AuditDto;
import com.ojtbank.common.dto.PaymentDto;
import com.ojtbank.domain.mapper.PaymentMapper;
import com.ojtbank.domain.model.Rcp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

public class PaymentMyBatisDaoImpl implements PaymentDao{

    private final PaymentMapper paymentMapper;

    @Autowired
    public PaymentMyBatisDaoImpl(PaymentMapper paymentMapper) {
        this.paymentMapper = paymentMapper;
    }

    @Override
    public void payment(PaymentDto paymentDto) {
        AuditDto auditDto = AuditContext.getAudioDto();
        Rcp rcp = new Rcp(auditDto.getOpr_id(), auditDto.getOpr_trm_id(), auditDto.getMng_id(), auditDto.getOrg_id(), LocalDateTime.now(), LocalDateTime.now(), paymentDto.getTrx_seq(), paymentDto.getAcc_no(), paymentDto.getTrx_datetime(), paymentDto.getAmt(), paymentDto.getTrx_type());
        paymentMapper.insertPayment(rcp);
    }

    @Override
    public void updateAccount(PaymentDto paymentDto) {
        AuditDto auditDto = AuditContext.getAudioDto();
        Rcp rcp = new Rcp(auditDto.getOpr_id(), auditDto.getOpr_trm_id(), auditDto.getMng_id(), auditDto.getOrg_id(), LocalDateTime.now(), LocalDateTime.now(), paymentDto.getTrx_seq(), paymentDto.getAcc_no(), paymentDto.getTrx_datetime(), paymentDto.getAmt(), paymentDto.getTrx_type());
        paymentMapper.updateAccount(rcp);
    }
}
