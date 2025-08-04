package com.ojtbank.common.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountDto {
    private String acc_no;
    private long amt;
    private String cus_no;
    private LocalDateTime createdAt;
}
