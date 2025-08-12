package com.ojtbank.domain.dao;

import com.ojtbank.common.dto.DepositDto;
import com.ojtbank.domain.mapper.DepositMapper;
import com.ojtbank.domain.model.Rcp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;


public class DepositMyBatisDaoImpl implements DepositDao{

    private final DepositMapper depositMapper;

    @Autowired
    public DepositMyBatisDaoImpl(DepositMapper depositMapper) {
        this.depositMapper = depositMapper;
    }

    @Override
    public void deposit(DepositDto depositDto) {
        Rcp rcp = new Rcp(depositDto.getTrx_seq(), depositDto.getAcc_no(), depositDto.getTrx_datetime(), depositDto.getAmt(), depositDto.getTrx_type());
        depositMapper.insertDeposit(rcp);
    }

    @Override
    public void updateAccount(DepositDto depositDto) {
        Rcp rcp = new Rcp(depositDto.getTrx_seq(), depositDto.getAcc_no(), depositDto.getTrx_datetime(), depositDto.getAmt(), depositDto.getTrx_type());
        depositMapper.updateAccount(rcp);
    }
}
