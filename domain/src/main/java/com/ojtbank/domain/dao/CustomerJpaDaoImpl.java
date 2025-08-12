package com.ojtbank.domain.dao;

import com.ojtbank.common.dto.AccountDto;
import com.ojtbank.common.dto.CustomerAccountDto;
import com.ojtbank.common.dto.CustomerDto;
import com.ojtbank.domain.model.Account;
import com.ojtbank.domain.model.Customer;
import com.ojtbank.domain.repository.AccountRepository;
import com.ojtbank.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class CustomerJpaDaoImpl implements CustomerDao{


    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerJpaDaoImpl(CustomerRepository customerRepository, AccountRepository accountRepository){
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void registerCustomer(CustomerDto customerDto) {
        Customer customer = new Customer(customerDto.getCus_no(), customerDto.getCus_nm(), customerDto.getCus_id(), customerDto.getCus_pw());
        customerRepository.save(customer);
    }

    @Override
    public CustomerDto selectCustomerByNo(String customerNo) {
        Customer customer = customerRepository.findById(customerNo).get();
        return new CustomerDto(customer.getCus_no(), customer.getCus_nm(), customer.getCus_id(), customer.getCus_pw());
    }

    @Override
    public void deleteCustomer(String customerNo) {
        customerRepository.deleteById(customerNo);
    }

    @Override
    public CustomerAccountDto selectAllCustomers(String customerNo) {
        Customer customer = customerRepository.findById(customerNo).get();
        List<Account> accountList = accountRepository.selectAllAccounts(customerNo);
        List<AccountDto> accountDtoList = new ArrayList<>();
        for(Account account : accountList){
            accountDtoList.add(new AccountDto(account.getAcc_no(), account.getAmt(), account.getCus_no(), account.getCreatedAt()));
        }

        return new CustomerAccountDto(customer.getCus_no(), customer.getCus_nm(), accountDtoList);
    }
}
