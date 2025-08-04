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
public class CustomerAccountDto {

    private String cus_no;
    private String cus_nm;
    private List<AccountDto> accounts;

}
