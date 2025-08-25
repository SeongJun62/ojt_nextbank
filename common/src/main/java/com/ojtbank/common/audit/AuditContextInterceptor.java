package com.ojtbank.common.audit;

import com.ojtbank.common.dto.AuditDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuditContextInterceptor implements HandlerInterceptor {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler) throws Exception {

        byte[] auditBytes = (byte[]) request.getAttribute("AUDIT_BYTES");

        AuditDto auditDto = objectMapper.readValue(auditBytes, AuditDto.class);
        System.out.println("Interceptor 작업");
        AuditContext.setAudioDto(auditDto);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception){
        AuditContext.clear();
    }
}
