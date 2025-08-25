package com.ojtbank.domain.dao;

import com.ojtbank.common.audit.AuditContext;
import com.ojtbank.common.dto.AuditDto;
import com.ojtbank.common.dto.DepositDto;
import com.ojtbank.domain.mapper.DepositMapper;
import com.ojtbank.domain.model.Rcp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;


public class DepositMyBatisDaoImpl implements DepositDao{

    private final DepositMapper depositMapper;

    @Autowired
    public DepositMyBatisDaoImpl(DepositMapper depositMapper) {
        this.depositMapper = depositMapper;
    }

    @Override
    public void deposit(DepositDto depositDto) {
        AuditDto auditDto = AuditContext.getAudioDto();
        Rcp rcp = new Rcp(auditDto.getOpr_id(), auditDto.getOpr_trm_id(), auditDto.getMng_id(), auditDto.getOrg_id(), LocalDateTime.now(), LocalDateTime.now(), depositDto.getTrx_seq(), depositDto.getAcc_no(), depositDto.getTrx_datetime(), depositDto.getAmt(), depositDto.getTrx_type());
        depositMapper.insertDeposit(rcp);
    }

    @Override
    public void updateAccount(DepositDto depositDto) {
        AuditDto auditDto = AuditContext.getAudioDto();
        Rcp rcp = new Rcp(auditDto.getOpr_id(), auditDto.getOpr_trm_id(), auditDto.getMng_id(), auditDto.getOrg_id(), LocalDateTime.now(), LocalDateTime.now(), depositDto.getTrx_seq(), depositDto.getAcc_no(), depositDto.getTrx_datetime(), depositDto.getAmt(), depositDto.getTrx_type());
        depositMapper.updateAccount(rcp);
    }
}
