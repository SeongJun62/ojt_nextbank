package com.ojtbank.domain.dao;

import com.ojtbank.common.audit.AuditContext;
import com.ojtbank.common.dto.AuditDto;
import com.ojtbank.common.dto.DepositDto;
import com.ojtbank.domain.model.Rcp;
import com.ojtbank.domain.repository.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

public class DepositJpaDaoImpl implements DepositDao{

    private final DepositRepository depositRepository;

    @Autowired
    public DepositJpaDaoImpl(DepositRepository depositRepository){
        this.depositRepository = depositRepository;
    }

    @Override
    public void deposit(DepositDto depositDto) {
        AuditDto auditDto = AuditContext.getAudioDto();
        Rcp rcp = new Rcp(auditDto.getOpr_id(), auditDto.getOpr_trm_id(), auditDto.getMng_id(), auditDto.getOrg_id(), LocalDateTime.now(), LocalDateTime.now(), depositDto.getTrx_seq(), depositDto.getAcc_no(), LocalDateTime.now(), depositDto.getAmt(), "deposit");
        depositRepository.save(rcp);
    }

    @Override
    public void updateAccount(DepositDto depositDto) {
        depositRepository.updateAccount(depositDto.getAmt(), depositDto.getAcc_no(), LocalDateTime.now());
    }
}
