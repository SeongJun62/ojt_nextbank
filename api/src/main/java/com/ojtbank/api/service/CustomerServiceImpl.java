package com.ojtbank.api.service;

import com.ojtbank.common.dto.CustomerAccountDto;
import com.ojtbank.common.dto.CustomerDto;
import com.ojtbank.domain.dao.CustomerDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao){
        this.customerDao = customerDao;
    }

    @Override
    public void registerCustomer(CustomerDto customerDto) {
        customerDao.registerCustomer(customerDto);
    }

    @Override
    public CustomerDto getCustomerByNo(String customerId) {
        return customerDao.selectCustomerByNo(customerId);
    }

    @Override
    public void deleteCustomer(String customerId) {
        customerDao.deleteCustomer(customerId);
    }

    @Override
    public CustomerAccountDto getAllAccount(String customerId) {
        return customerDao.selectAllCustomers(customerId);
    }
}
