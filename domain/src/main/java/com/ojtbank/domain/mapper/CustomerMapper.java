package com.ojtbank.domain.mapper;

import com.ojtbank.domain.model.Account;
import com.ojtbank.domain.model.Customer;
import com.ojtbank.domain.model.Rcp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    void insertCustomer(Customer customer);
    void deleteCustomer(String cus_no);
    Customer selectCustomerByNo(String cus_no);
    List<Account> selectAllAccountByNo(String cus_no);
}
