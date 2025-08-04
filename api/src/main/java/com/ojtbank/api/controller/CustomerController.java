package com.ojtbank.api.controller;

import com.ojtbank.common.dto.AccountDto;
import com.ojtbank.common.dto.CustomerAccountDto;
import com.ojtbank.common.dto.CustomerDto;
import com.ojtbank.api.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> registerCustomer(@RequestBody CustomerDto customerDto){
        customerService.registerCustomer(customerDto);
        return ResponseEntity.ok("회원 등록 완료");
    }

    @DeleteMapping("/{cus_no}")
    public ResponseEntity<String>  deleteCustomer(@PathVariable("cus_no") String cus_no){
        customerService.deleteCustomer(cus_no);
        return ResponseEntity.ok("고객 삭제 완료");
    }

    @GetMapping("/{cus_no}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("cus_no") String cus_no){
        CustomerDto customerDto = customerService.getCustomerByNo(cus_no);
        return ResponseEntity.ok(customerDto);
    }

    @GetMapping("/{cus_no}/accounts")
    public ResponseEntity<List<AccountDto>> getCustomerAccounts(@PathVariable("cus_no") String cus_no) {
        CustomerAccountDto customerAccountDto = customerService.getAllAccount(cus_no);
        return ResponseEntity.ok(customerAccountDto.getAccounts());
    }
}
