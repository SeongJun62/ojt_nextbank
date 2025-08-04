package com.ojtbank.domain.dao;

import com.ojtbank.common.dto.CustomerAccountDto;
import com.ojtbank.common.dto.CustomerDto;

public interface CustomerDao {
    void registerCustomer(CustomerDto customerDto);
    CustomerDto selectCustomerByNo(String customerId);
    void deleteCustomer(String customerId);
    CustomerAccountDto selectAllCustomers(String customerId);

}
