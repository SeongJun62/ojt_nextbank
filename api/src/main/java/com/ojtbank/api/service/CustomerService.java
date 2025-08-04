package com.ojtbank.api.service;

import com.ojtbank.common.dto.CustomerAccountDto;
import com.ojtbank.common.dto.CustomerDto;

public interface CustomerService {
    void registerCustomer(CustomerDto customerDto);
    CustomerDto getCustomerByNo(String customerId);
    void deleteCustomer(String customerId);
    CustomerAccountDto getAllAccount(String customerId);
}
