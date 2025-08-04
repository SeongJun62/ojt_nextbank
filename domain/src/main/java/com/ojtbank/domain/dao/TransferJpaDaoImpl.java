package com.ojtbank.domain.dao;

import com.ojtbank.common.dto.TransferDto;
import com.ojtbank.domain.model.Transfer;
import com.ojtbank.domain.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
@Primary
public class TransferJpaDaoImpl implements TransferDao{

    private final TransferRepository transferRepository;

    @Autowired
    public TransferJpaDaoImpl(TransferRepository transferRepository){
        this.transferRepository = transferRepository;
    }

    @Override
    public void transfer(TransferDto transferDto) {
        Transfer transfer = new Transfer(transferDto.getTrx_seq(), transferDto.getSnd_acc_no(), transferDto.getRcv_acc_no(), LocalDateTime.now(), transferDto.getAmt(), "transfer");
        transferRepository.save(transfer);
    }

    @Override
    public void updateSndAccount(TransferDto transferDto) {
        transferRepository.updateSndAccount(transferDto.getAmt(), transferDto.getSnd_acc_no());
    }

    @Override
    public void updateRcvAccount(TransferDto transferDto) {
        transferRepository.updateRcvAccount(transferDto.getAmt(), transferDto.getRcv_acc_no());
    }
}
