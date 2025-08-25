package com.ojtbank.domain.dao;

import com.ojtbank.common.audit.AuditContext;
import com.ojtbank.common.dto.AuditDto;
import com.ojtbank.common.dto.TransferDto;
import com.ojtbank.domain.mapper.TransferMapper;
import com.ojtbank.domain.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;


public class TransferMyBatisDaoImpl implements TransferDao{

    private final TransferMapper transferMapper;

    @Autowired
    public TransferMyBatisDaoImpl(TransferMapper transferMapper) {
        this.transferMapper = transferMapper;
    }


    @Override
    public void transfer(TransferDto transferDto) {
        AuditDto auditDto = AuditContext.getAudioDto();
        Transfer transfer = new Transfer(auditDto.getOpr_id(), auditDto.getOpr_trm_id(), auditDto.getMng_id(), auditDto.getOrg_id(), LocalDateTime.now(), LocalDateTime.now(), transferDto.getTrx_seq(), transferDto.getSnd_acc_no(), transferDto.getRcv_acc_no(), transferDto.getTrx_datetime(), transferDto.getAmt(), transferDto.getTrx_type());
        transferMapper.insertTransfer(transfer);
    }

    @Override
    public void updateSndAccount(TransferDto transferDto) {
        Transfer transfer = new Transfer(transferDto.getTrx_seq(), transferDto.getSnd_acc_no(), transferDto.getRcv_acc_no(), transferDto.getTrx_datetime(), transferDto.getAmt(), transferDto.getTrx_type());
        transferMapper.updateSndAccount(transfer);
    }

    @Override
    public void updateRcvAccount(TransferDto transferDto) {
        Transfer transfer = new Transfer(transferDto.getTrx_seq(), transferDto.getSnd_acc_no(), transferDto.getRcv_acc_no(), transferDto.getTrx_datetime(), transferDto.getAmt(), transferDto.getTrx_type());
        transferMapper.updateRcvAccount(transfer);
    }
}
