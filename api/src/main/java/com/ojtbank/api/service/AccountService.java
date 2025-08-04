package com.ojtbank.api.service;

import com.ojtbank.common.dto.AccountDto;
import com.ojtbank.common.dto.TransactionDto;

import java.util.List;

public interface AccountService {
    void registerAccount(AccountDto account);
    void deleteAccount(String accountId);
    AccountDto getAccountByNo(String accountNo);
    List<TransactionDto> getTransactionsByNo(String accountNo);
}
