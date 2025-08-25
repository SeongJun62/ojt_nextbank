package com.ojtbank.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "trx_list")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transfer extends BaseAuditModel{

    public Transfer(String opr_id, String opr_trm_id, String mng_id, String org_id, LocalDateTime create_time, LocalDateTime update_time, String trx_seq, String snd_acc_no, String rcv_acc_no, LocalDateTime trx_datetime, long amt, String trx_type){
        super(opr_id, opr_trm_id, mng_id, org_id, create_time, update_time);
        this.trx_seq = trx_seq;
        this.snd_acc_no = snd_acc_no;
        this.rcv_acc_no = rcv_acc_no;
        this.trx_datetime = trx_datetime;
        this.amt = amt;
        this.trx_type = trx_type;
    }

    @Id
    private String trx_seq;

    private String snd_acc_no;

    private String rcv_acc_no;

    private LocalDateTime trx_datetime;

    private long amt;

    private String trx_type;

}
