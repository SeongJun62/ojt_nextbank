package com.ojtbank.api.service;

import com.ojtbank.common.dto.TransferDto;
import com.ojtbank.domain.dao.TransferDao;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Transactional
public class TransferServiceImpl implements TransferService{

    private final TransferDao transferDao;

    public TransferServiceImpl(TransferDao transferDao){
        this.transferDao = transferDao;
    }
    @Override
    public void transfer(TransferDto transferDto) {
        transferDao.transfer(transferDto);
        transferDao.updateSndAccount(transferDto);
        transferDao.updateRcvAccount(transferDto);
    }
}
