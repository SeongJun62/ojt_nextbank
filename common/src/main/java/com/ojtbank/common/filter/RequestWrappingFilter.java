package com.ojtbank.common.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class RequestWrappingFilter extends OncePerRequestFilter {

    private final ObjectMapper om = new ObjectMapper();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        CachedBodyHttpServletRequest wrappedRequest = new CachedBodyHttpServletRequest(request);

        byte[] body = wrappedRequest.getInputStream().readAllBytes();

        JsonNode root = om.readTree(body);

        byte[] dataBytes = toBytes(root.path("data"));
        byte[] auditBytes = toBytes((root.path("audit")));

        wrappedRequest.setAttribute("DATA_BYTES", dataBytes);
        wrappedRequest.setAttribute("AUDIT_BYTES", auditBytes);

        System.out.println("Filter 작업");
        filterChain.doFilter(wrappedRequest, response);

    }

    private byte[] toBytes(JsonNode node) throws JsonProcessingException {
        if (node == null || node.isMissingNode() || node.isNull()) return new byte[0];
        return om.writeValueAsBytes(node); // 노드만 그대로 JSON bytes로
    }
}
