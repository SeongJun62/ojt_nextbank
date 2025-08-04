package com.ojtbank.domain.repository;

import com.ojtbank.domain.model.Transfer;
import jakarta.transaction.Transactional;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransferRepository extends JpaRepository<Transfer, String> {

    @Modifying
    @Transactional
    @Query(value="UPDATE acc_mst SET amt = amt - :amt WHERE acc_no = :snd_acc_no", nativeQuery=true)
    void updateSndAccount(@Param("amt") long amt, @Param("snd_acc_no") String snd_acc_no);

    @Modifying
    @Transactional
    @Query(value = "UPDATE acc_mst SET amt = amt + :amt WHERE acc_no = :rcv_acc_no", nativeQuery = true)
    void updateRcvAccount(@Param("amt") long amt, @Param("rcv_acc_no") String rcv_acc_no);

    @Query(value = "SELECT * FROM trx_list WHERE snd_acc_no = :acc_no OR rcv_acc_no = :acc_no", nativeQuery = true)
    List<Transfer> selectAllTransfers(@org.springframework.data.repository.query.Param("acc_no") String acc_no);
}
