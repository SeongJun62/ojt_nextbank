package com.ojtbank.api.controller;

import com.ojtbank.common.dto.PaymentDto;
import com.ojtbank.api.service.PaymentService;
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
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<String> payment(@RequestBody PaymentDto paymentDto){
        paymentService.payment(paymentDto);
        return ResponseEntity.ok("출금 완료");
    }
}
