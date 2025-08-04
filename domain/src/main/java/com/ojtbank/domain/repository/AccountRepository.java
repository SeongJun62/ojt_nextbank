package com.ojtbank.domain.repository;

import com.ojtbank.domain.model.Account;
import com.ojtbank.domain.model.Rcp;
import com.ojtbank.domain.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {





    @Query(value = "SELECT * FROM acc_mst WHERE cus_no = :cus_no", nativeQuery = true)
    List<Account> selectAllAccounts(@Param("cus_no") String cus_no);
}
