package com.ojtbank.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name="cus_mst")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer extends BaseAuditModel{

    public Customer(String opr_id, String opr_trm_id, String mng_id, String org_id, LocalDateTime create_time, LocalDateTime update_time, String cus_no, String cus_nm, String cus_id, String cus_pw){
        super(opr_id, opr_trm_id, mng_id, org_id, create_time, update_time);
        this.cus_no = cus_no;
        this.cus_nm = cus_nm;
        this.cus_id = cus_id;
        this.cus_pw = cus_pw;
    }

    @Id
    private String cus_no;

    private String cus_nm;

    private String cus_id;

    private String cus_pw;
}
