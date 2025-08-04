package com.ojtbank.domain.dao;

import com.ojtbank.common.dto.DepositDto;
import com.ojtbank.domain.model.Rcp;
import com.ojtbank.domain.repository.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
@Primary
public class DepositJpaDaoImpl implements DepositDao{

    private final DepositRepository depositRepository;

    @Autowired
    public DepositJpaDaoImpl(DepositRepository depositRepository){
        this.depositRepository = depositRepository;
    }

    @Override
    public void deposit(DepositDto depositDto) {
        Rcp rcp = new Rcp(depositDto.getTrx_seq(), depositDto.getAcc_no(), LocalDateTime.now(), depositDto.getAmt(), "deposit");
        depositRepository.save(rcp);
    }

    @Override
    public void updateAccount(DepositDto depositDto) {
        depositRepository.updateAccount(depositDto.getAmt(), depositDto.getAcc_no());
    }
}
