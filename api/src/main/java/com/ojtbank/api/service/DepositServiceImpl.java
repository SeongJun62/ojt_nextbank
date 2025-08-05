package com.ojtbank.api.service;

import com.ojtbank.common.dto.DepositDto;
import com.ojtbank.domain.dao.DepositDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class DepositServiceImpl implements DepositService{

    private final DepositDao depositDao;
    public DepositServiceImpl(DepositDao depositDao){
        this.depositDao = depositDao;
    }

    @Override
    public void deposit(DepositDto depositDto) {
        depositDao.deposit(depositDto);
        depositDao.updateAccount(depositDto);
    }
}
