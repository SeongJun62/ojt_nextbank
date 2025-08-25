package com.ojtbank.common.audit;

import com.ojtbank.common.dto.AuditDto;

public class AuditContext {
    private static final ThreadLocal<AuditDto> auditDtoThreadLocal= new ThreadLocal<>();

    static void setAudioDto(AuditDto auditDto){
        auditDtoThreadLocal.set(auditDto);
    }

    public static AuditDto getAudioDto(){
        return auditDtoThreadLocal.get();
    }

    static void clear() {
        auditDtoThreadLocal.remove();
    }
}
