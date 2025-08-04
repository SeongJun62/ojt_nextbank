package com.ojtbank.domain.mapper;

import com.ojtbank.domain.model.Account;
import com.ojtbank.domain.model.Rcp;
import com.ojtbank.domain.model.Transfer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {
    void insertAccount(Account account);
    void deleteAccount(String acc_no);
    Account selectAccount(String acc_no);
    List<Rcp> selectAllRcps(String acc_no);
    List<Transfer> selectAllTransfers(String acc_no);
}