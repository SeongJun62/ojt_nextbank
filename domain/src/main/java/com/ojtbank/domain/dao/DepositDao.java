package com.ojtbank.domain.dao;

import com.ojtbank.common.dto.DepositDto;

public interface DepositDao {
    void deposit(DepositDto depositDto);
    void updateAccount(DepositDto depositDto);
}
