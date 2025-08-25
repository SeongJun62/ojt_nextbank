package com.ojtbank.domain.model;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
public class BaseAuditModel {

    private String opr_id;
    private String opr_trm_id;
    private String mng_id;
    private String org_id;
    private LocalDateTime create_time;
    private LocalDateTime update_time;
}
