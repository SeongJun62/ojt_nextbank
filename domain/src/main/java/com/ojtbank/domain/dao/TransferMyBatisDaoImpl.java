package com.ojtbank.domain.dao;

import com.ojtbank.common.dto.TransferDto;
import com.ojtbank.domain.mapper.TransferMapper;
import com.ojtbank.domain.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransferMyBatisDaoImpl implements TransferDao{

    private final TransferMapper transferMapper;

    @Autowired
    public TransferMyBatisDaoImpl(TransferMapper transferMapper) {
        this.transferMapper = transferMapper;
    }


    @Override
    public void transfer(TransferDto transferDto) {
        Transfer transfer = new Transfer(transferDto.getTrx_seq(), transferDto.getSnd_acc_no(), transferDto.getSnd_acc_no(), transferDto.getTrx_datetime(), transferDto.getAmt(), transferDto.getTrx_type());
        transferMapper.insertTransfer(transfer);
    }

    @Override
    public void updateSndAccount(TransferDto transferDto) {
        Transfer transfer = new Transfer(transferDto.getTrx_seq(), transferDto.getSnd_acc_no(), transferDto.getSnd_acc_no(), transferDto.getTrx_datetime(), transferDto.getAmt(), transferDto.getTrx_type());
        transferMapper.updateSndAccount(transfer);
    }

    @Override
    public void updateRcvAccount(TransferDto transferDto) {
        Transfer transfer = new Transfer(transferDto.getTrx_seq(), transferDto.getSnd_acc_no(), transferDto.getSnd_acc_no(), transferDto.getTrx_datetime(), transferDto.getAmt(), transferDto.getTrx_type());
        transferMapper.updateRcvAccount(transfer);
    }
}
