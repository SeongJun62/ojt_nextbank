package com.ojtbank.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ojtbank.common.dto.AccountDto;
import com.ojtbank.common.dto.TransactionDto;
import com.ojtbank.api.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping
    public ResponseEntity<String> registerAccount(@RequestAttribute("DATA_BYTES") byte[] dataBytes) throws Exception{

        AccountDto accountDto = objectMapper.readValue(dataBytes, AccountDto.class);
        accountService.registerAccount(accountDto);
        return ResponseEntity.ok("계좌 등록 완료");
    }

    @PostMapping("/delete/{acc_no}")
    public ResponseEntity<String> deleteAccount(@PathVariable("acc_no") String acc_no){
        accountService.deleteAccount(acc_no);
        return ResponseEntity.ok("계좌 삭제 완료");
    }

    @PostMapping("/{acc_no}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable("acc_no") String acc_no){
        AccountDto accountDto = accountService.getAccountByNo(acc_no);
        return ResponseEntity.ok(accountDto);
    }

    @PostMapping("/transactions/{acc_no}")
    public ResponseEntity<List<TransactionDto>> getAccountTransactions(@PathVariable("acc_no") String acc_no){
        List<TransactionDto> accountTransactionDtolist = accountService.getTransactionsByNo(acc_no);
        return ResponseEntity.ok(accountTransactionDtolist);
    }

}
