package com.ojtbank.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rcp_History {
    private String trx_seq;
    private String acc_no;
    private LocalDateTime trx_datetime;
    private long amt;
    private String trx_type;
    private String status;
}
