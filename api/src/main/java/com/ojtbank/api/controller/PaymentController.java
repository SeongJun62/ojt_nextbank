package com.ojtbank.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ojtbank.common.dto.PaymentDto;
import com.ojtbank.api.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping
    public ResponseEntity<String> payment(@RequestAttribute("DATA_BYTES") byte[] dataBytes) throws Exception{

        PaymentDto paymentDto = objectMapper.readValue(dataBytes, PaymentDto.class);
        paymentService.payment(paymentDto);
        return ResponseEntity.ok("출금 완료");
    }
}
