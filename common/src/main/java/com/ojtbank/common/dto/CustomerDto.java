package com.ojtbank.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private String cus_no;
    private String cus_nm;
    private String cus_id;
    private String cus_pw;
}
