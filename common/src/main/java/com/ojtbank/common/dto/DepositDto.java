package com.ojtbank.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepositDto extends TransactionDto{
    private String acc_no;

    public DepositDto(String trxSeq, long amt, LocalDateTime trxDatetime, String trxType, String accNo) {
        super(trxSeq, amt, trxDatetime, trxType);
        this.acc_no = accNo;
    }
}
