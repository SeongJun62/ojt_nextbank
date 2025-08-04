package com.ojtbank.domain.repository;

import com.ojtbank.domain.model.Account;
import com.ojtbank.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {



}
