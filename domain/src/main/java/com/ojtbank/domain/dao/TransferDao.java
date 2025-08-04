package com.ojtbank.domain.dao;

import com.ojtbank.common.dto.TransferDto;

public interface TransferDao {
    void transfer(TransferDto transferDto);
    void updateSndAccount(TransferDto transferDto);
    void updateRcvAccount(TransferDto transferDto);
}
