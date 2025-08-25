package com.ojtbank.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ojtbank.common.dto.DepositDto;
import com.ojtbank.api.service.DepositService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/deposit")
public class DepositController {

    private final DepositService depositService;
    private final ObjectMapper objectMapper = new ObjectMapper();


    @PostMapping
    public ResponseEntity<String> deposit(@RequestAttribute("DATA_BYTES") byte[] dataBytes) throws Exception{

        DepositDto depositDto = objectMapper.readValue(dataBytes, DepositDto.class);
        depositService.deposit(depositDto);
        return ResponseEntity.ok("거래 성공");
    }
}
