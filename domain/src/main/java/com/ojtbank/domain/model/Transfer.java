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
public class Transfer {

    @Id
    private String trx_seq;

    private String snd_acc_no;

    private String rcv_acc_no;

    private LocalDateTime trx_datetime;

    private long amt;

    private String trx_type;

}
