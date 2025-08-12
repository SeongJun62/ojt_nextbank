package com.ojtbank.domain.dao;

import com.ojtbank.common.dto.AccountDto;
import com.ojtbank.common.dto.CustomerAccountDto;
import com.ojtbank.common.dto.CustomerDto;
import com.ojtbank.domain.mapper.CustomerMapper;
import com.ojtbank.domain.model.Account;
import com.ojtbank.domain.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class CustomerMyBatisDaoImpl implements CustomerDao{


    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerMyBatisDaoImpl(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Override
    public void registerCustomer(CustomerDto customerDto) {
        Customer customer = new Customer(customerDto.getCus_no(), customerDto.getCus_nm(), customerDto.getCus_id(), customerDto.getCus_pw());
        customerMapper.insertCustomer(customer);
    }

    @Override
    public CustomerDto selectCustomerByNo(String customerNo) {
        Customer customer = customerMapper.selectCustomerByNo(customerNo);
        return new CustomerDto(customer.getCus_no(), customer.getCus_nm(), customer.getCus_id(), customer.getCus_pw());
    }

    @Override
    public void deleteCustomer(String customerId) {
        customerMapper.deleteCustomer(customerId);
    }

    @Override
    public CustomerAccountDto selectAllCustomers(String customerId) {
        Customer customer = customerMapper.selectCustomerByNo(customerId);
        List<Account> list = customerMapper.selectAllAccountByNo(customerId);
        List<AccountDto> accountDtoList = new ArrayList<>();
        for(Account account : list){
            accountDtoList.add(new AccountDto(account.getAcc_no(), account.getAmt(), account.getCus_no(), account.getCreatedAt()));
        }

        return new CustomerAccountDto(customer.getCus_no(), customer.getCus_nm(), accountDtoList);
    }

}
