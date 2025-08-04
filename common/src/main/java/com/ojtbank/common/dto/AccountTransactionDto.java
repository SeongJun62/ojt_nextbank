package com.ojtbank.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountTransactionDto {
    private String acc_no;
    private long amt;
    private List<TransactionDto> transactions;
}
