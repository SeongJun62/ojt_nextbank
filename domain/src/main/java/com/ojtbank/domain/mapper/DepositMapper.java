package com.ojtbank.domain.mapper;

import com.ojtbank.domain.model.Rcp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepositMapper {
    void insertDeposit(Rcp rcp);
    void updateAccount(Rcp rcp);
}
