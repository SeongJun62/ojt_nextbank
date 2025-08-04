package com.ojtbank.domain.dao;

import com.ojtbank.common.dto.AccountDto;
import com.ojtbank.common.dto.AccountTransactionDto;
import com.ojtbank.common.dto.TransactionDto;

import java.util.List;

public interface AccountDao {
    void registerAccount(AccountDto accountDto);
    void deleteAccount(String accountNo);
    AccountDto getAccountByNo(String accountNo);
    List<TransactionDto> getRcpsByNo(String accountNo);
    List<TransactionDto> getTransfersByNo(String accountNo);
}
