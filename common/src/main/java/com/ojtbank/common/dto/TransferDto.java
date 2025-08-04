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
public class TransferDto extends TransactionDto{
    private String snd_acc_no;
    private String rcv_acc_no;

    public TransferDto(String trxSeq, long amt, LocalDateTime trxDatetime, String trxType, String sndAccNo, String rcvAccNo) {
        super(trxSeq, amt, trxDatetime, trxType);
        this.snd_acc_no = sndAccNo;
        this.rcv_acc_no = rcvAccNo;
    }
}
