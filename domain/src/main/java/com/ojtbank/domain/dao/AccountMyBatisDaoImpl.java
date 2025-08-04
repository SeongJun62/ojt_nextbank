package com.ojtbank.domain.dao;

import ch.qos.logback.core.CoreConstants;
import com.ojtbank.common.dto.*;
import com.ojtbank.domain.mapper.AccountMapper;
import com.ojtbank.domain.model.Account;
import com.ojtbank.domain.model.Rcp;
import com.ojtbank.domain.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountMyBatisDaoImpl implements AccountDao{

    private final AccountMapper accountMapper;

    @Autowired
    public AccountMyBatisDaoImpl(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public void registerAccount(AccountDto accountDto) {
        Account account = new Account(accountDto.getAcc_no(), accountDto.getAmt(), accountDto.getCus_no(), accountDto.getCreatedAt());
        accountMapper.insertAccount(account);
    }

    @Override
    public void deleteAccount(String accountNo) {
        accountMapper.deleteAccount(accountNo);
    }

    @Override
    public AccountDto getAccountByNo(String accountNo) {
        Account account = accountMapper.selectAccount(accountNo);
        System.out.println("조회된 계좌는 다음과 같습니다 : " + account);
        return new AccountDto(account.getAcc_no(), account.getAmt(), account.getCus_no(), account.getCreatedAt());
    }

    @Override
    public List<TransactionDto> getRcpsByNo(String accountNo) {
        List<Rcp> rcpList = accountMapper.selectAllRcps(accountNo);
        List<TransactionDto> transactionDtoList = new ArrayList<>();
        for(Rcp rcp: rcpList){
            if(rcp.getTrx_type().equals("deposit")){
                transactionDtoList.add(new DepositDto(rcp.getTrx_seq(), rcp.getAmt(), rcp.getTrx_datetime(), rcp.getTrx_type(), rcp.getAcc_no()));
            }
            else{
                transactionDtoList.add(new PaymentDto(rcp.getTrx_seq(), rcp.getAmt(), rcp.getTrx_datetime(), rcp.getTrx_type(), rcp.getAcc_no()));
            }
        }
        return transactionDtoList;
    }

    @Override
    public List<TransactionDto> getTransfersByNo(String accountNo) {
        List<Transfer> transferList = accountMapper.selectAllTransfers(accountNo);
        List<TransactionDto> transactionDtoList = new ArrayList<>();
        for(Transfer transfer: transferList){
            transactionDtoList.add(new TransferDto(transfer.getTrx_seq(), transfer.getAmt(), transfer.getTrx_datetime(), transfer.getTrx_type(), transfer.getSnd_acc_no(), transfer.getRcv_acc_no()));
        }
        return transactionDtoList;
    }
}
