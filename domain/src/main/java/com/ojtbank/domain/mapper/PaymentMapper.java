package com.ojtbank.domain.mapper;

import com.ojtbank.domain.model.Rcp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {
    void insertPayment(Rcp rcp);
    void updateAccount(Rcp rcp);
}
