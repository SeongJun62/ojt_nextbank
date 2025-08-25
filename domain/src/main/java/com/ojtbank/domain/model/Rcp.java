package com.ojtbank.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "rcp_list")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rcp extends BaseAuditModel{

    public Rcp(String opr_id, String opr_trm_id, String mng_id, String org_id, LocalDateTime create_time, LocalDateTime update_time, String trx_seq, String acc_no, LocalDateTime trx_datetime, long amt, String trx_type){
        super(opr_id, opr_trm_id, mng_id, org_id, create_time, update_time);
        this.trx_seq = trx_seq;
        this.acc_no = acc_no;
        this.trx_datetime = trx_datetime;
        this.amt = amt;
        this.trx_type = trx_type;
    }
    @Id
    private String trx_seq;

    private String acc_no;

    private LocalDateTime trx_datetime;

    private long amt;

    private String trx_type;
}
