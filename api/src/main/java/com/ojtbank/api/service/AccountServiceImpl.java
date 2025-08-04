package com.ojtbank.api.service;

import com.ojtbank.common.dto.AccountDto;
import com.ojtbank.common.dto.TransactionDto;
import com.ojtbank.domain.dao.AccountDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService{
    private final AccountDao accountDao;

    public AccountServiceImpl(AccountDao accountDao){
        this.accountDao = accountDao;
    }

    @Override
    public void registerAccount(AccountDto account) {
        accountDao.registerAccount(account);
    }

    @Override
    public void deleteAccount(String accountNo) {        accountDao.deleteAccount(accountNo);
    }

    @Override
    public AccountDto getAccountByNo(String accountNo) {
        return accountDao.getAccountByNo(accountNo);
    }

    @Override
    public List<TransactionDto> getTransactionsByNo(String accountNo) {
        List<TransactionDto> rcplist = accountDao.getRcpsByNo(accountNo);
        List<TransactionDto> transferlist = accountDao.getTransfersByNo(accountNo);
        rcplist.addAll(transferlist);
        return rcplist;
    }
}
