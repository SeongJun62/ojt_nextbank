package com.ojtbank.api.controller;

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

    @PostMapping
    public ResponseEntity<String> registerAccount(@RequestBody AccountDto accountDto){
        accountService.registerAccount(accountDto);
        return ResponseEntity.ok("계좌 등록 완료");
    }

    @DeleteMapping("/{acc_no}")
    public ResponseEntity<String> deleteAccount(@PathVariable("acc_no") String acc_no){
        accountService.deleteAccount(acc_no);
        return ResponseEntity.ok("계좌 삭제 완료");
    }

    @GetMapping("/{acc_no}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable("acc_no") String acc_no){
        AccountDto accountDto = accountService.getAccountByNo(acc_no);
        return ResponseEntity.ok(accountDto);
    }

    @GetMapping("/{acc_no}/transactions")
    public ResponseEntity<List<TransactionDto>> getAccountTransactions(@PathVariable("acc_no") String acc_no){
        List<TransactionDto> accountTransactionDtolist = accountService.getTransactionsByNo(acc_no);
        return ResponseEntity.ok(accountTransactionDtolist);
    }

}
