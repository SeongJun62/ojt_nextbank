package com.ojtbank.domain.mapper;

import com.ojtbank.domain.model.Transfer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TransferMapper {
    void insertTransfer(Transfer transfer);
    void updateSndAccount(Transfer transfer);
    void updateRcvAccount(Transfer transfer);
}
