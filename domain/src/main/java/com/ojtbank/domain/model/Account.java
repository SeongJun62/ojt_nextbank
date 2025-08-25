package com.ojtbank.domain.model;

import com.ojtbank.domain.repository.AccountRepository;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name="acc_mst")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Account extends BaseAuditModel{

    public Account(String opr_id, String opr_trm_id, String mng_id, String org_id, LocalDateTime create_time, LocalDateTime update_time, String acc_no, long amt, String cus_no, LocalDateTime createdAt){
        super(opr_id, opr_trm_id, mng_id, org_id, create_time, update_time);
        this.acc_no = acc_no;
        this.amt = amt;
        this.cus_no = cus_no;
        this.createdAt = createdAt;
    }

    @Id
    @Column(name="acc_no")
    private String acc_no;

    private long amt;

    private String cus_no;

    @Column(name="createdAt")
    private LocalDateTime createdAt;
}
