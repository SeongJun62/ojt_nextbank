package com.ojtbank.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ojtbank.common.dto.TransferDto;
import com.ojtbank.api.service.TransferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/transfer")
public class TransferController {

    private final TransferService transferService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping
    public ResponseEntity<String>  transfer(@RequestAttribute("DATA_BYTES") byte[] dataBytes) throws Exception{

        TransferDto transferDto = objectMapper.readValue(dataBytes, TransferDto.class);
        transferService.transfer(transferDto);
        return ResponseEntity.ok("거래 완료");
    }

}
