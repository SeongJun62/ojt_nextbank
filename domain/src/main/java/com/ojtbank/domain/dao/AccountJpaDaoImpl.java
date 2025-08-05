package com.ojtbank.domain.dao;

import com.ojtbank.common.dto.*;
import com.ojtbank.domain.model.Account;
import com.ojtbank.domain.model.Rcp;
import com.ojtbank.domain.model.Transfer;
import com.ojtbank.domain.repository.AccountRepository;
import com.ojtbank.domain.repository.DepositRepository;
import com.ojtbank.domain.repository.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@ConditionalOnProperty(name = "dao.impl-type", havingValue = "jpa")
public class AccountJpaDaoImpl implements AccountDao{

    private final AccountRepository accountRepository;
    private final TransferRepository transferRepository;
    private final DepositRepository depositRepository;

    @Autowired
    public AccountJpaDaoImpl(AccountRepository accountRepository, TransferRepository transferRepository, DepositRepository depositRepository){
        System.out.println("✅ AccountJpaDaoImpl 생성됨! repository: " + accountRepository);
        this.accountRepository = accountRepository;
        this.transferRepository = transferRepository;
        this.depositRepository = depositRepository;
    }

    @Override
    public void registerAccount(AccountDto accountDto) {
        Account account = new Account(accountDto.getAcc_no(), accountDto.getAmt(), accountDto.getCus_no(), LocalDateTime.now());
        accountRepository.save(account);
    }

    @Override
    public void deleteAccount(String accountNo) {
        accountRepository.deleteById(accountNo);
    }

    @Override
    public AccountDto getAccountByNo(String accountNo) {
        Account account = accountRepository.findById(accountNo).get();
        System.out.println("JPA로 찾은 계좌는 다음과 같습니다. : " + account);
        return new AccountDto(account.getAcc_no(), account.getAmt(), account.getCus_no(), account.getCreatedAt());
    }

    @Override
    public List<TransactionDto> getRcpsByNo(String accountNo) {
        List<Rcp> rcpList = depositRepository.selectAllRcps(accountNo);
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
        List<Transfer> transferList = transferRepository.selectAllTransfers(accountNo);
        List<TransactionDto> transactionDtoList = new ArrayList<>();
        for(Transfer transfer: transferList){
            transactionDtoList.add(new TransferDto(transfer.getTrx_seq(), transfer.getAmt(), transfer.getTrx_datetime(), transfer.getTrx_type(), transfer.getSnd_acc_no(), transfer.getRcv_acc_no()));
        }
        return transactionDtoList;
    }
}
