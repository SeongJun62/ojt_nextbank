package com.ojtbank.api.controller;

import com.ojtbank.common.dto.TransferDto;
import com.ojtbank.api.service.TransferService;
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
@RequestMapping("/transfer")
public class TransferController {

    private final TransferService transferService;

    @PostMapping
    public ResponseEntity<String>  transfer(@RequestBody TransferDto transferDto){
        transferService.transfer(transferDto);
        return ResponseEntity.ok("거래 완료");
    }

}
