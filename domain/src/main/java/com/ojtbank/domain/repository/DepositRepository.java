package com.ojtbank.domain.repository;

import com.ojtbank.domain.model.Rcp;
import jakarta.transaction.Transactional;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface DepositRepository extends JpaRepository<Rcp, String> {

    @Modifying
    @Transactional
    @Query(value= "UPDATE acc_mst SET amt = amt+ :amt, update_time = :update_time WHERE acc_no = :acc_no", nativeQuery = true)
    void updateAccount(@Param("amt") long amt, @Param("acc_no") String acc_no, @Param("update_time")LocalDateTime update_time);

    @Query(value = "SELECT * FROM rcp_list WHERE acc_no = :acc_no", nativeQuery = true)
    List<Rcp> selectAllRcps(@Param("acc_no") String acc_no);
}
