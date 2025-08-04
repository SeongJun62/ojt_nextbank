package com.ojtbank.api.controller;

import com.ojtbank.common.dto.DepositDto;
import com.ojtbank.api.service.DepositService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/deposit")
public class DepositController {

    private final DepositService depositService;

    @PostMapping
    public ResponseEntity<String> deposit(@RequestBody DepositDto depositDto){
        depositService.deposit(depositDto);
        return ResponseEntity.ok("거래 성공");
    }
}
