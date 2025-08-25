package com.ojtbank.domain.dao;

import com.ojtbank.common.audit.AuditContext;
import com.ojtbank.common.dto.AuditDto;
import com.ojtbank.common.dto.TransferDto;
import com.ojtbank.domain.model.Transfer;
import com.ojtbank.domain.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

public class TransferJpaDaoImpl implements TransferDao{

    private final TransferRepository transferRepository;

    @Autowired
    public TransferJpaDaoImpl(TransferRepository transferRepository){
        this.transferRepository = transferRepository;
    }

    @Override
    public void transfer(TransferDto transferDto) {
        AuditDto auditDto = AuditContext.getAudioDto();
        Transfer transfer = new Transfer(auditDto.getOpr_id(), auditDto.getOpr_trm_id(), auditDto.getMng_id(), auditDto.getOrg_id(), LocalDateTime.now(), LocalDateTime.now(), transferDto.getTrx_seq(), transferDto.getSnd_acc_no(), transferDto.getRcv_acc_no(), LocalDateTime.now(), transferDto.getAmt(), "transfer");
        transferRepository.save(transfer);
    }

    @Override
    public void updateSndAccount(TransferDto transferDto) {
        transferRepository.updateSndAccount(transferDto.getAmt(), transferDto.getSnd_acc_no(), LocalDateTime.now());
    }

    @Override
    public void updateRcvAccount(TransferDto transferDto) {
        transferRepository.updateRcvAccount(transferDto.getAmt(), transferDto.getRcv_acc_no(), LocalDateTime.now());
    }
}
