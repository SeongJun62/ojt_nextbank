package com.ojtbank.common.filter;

import jakarta.servlet.ReadListener;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.io.*;

public class CachedBodyHttpServletRequest extends HttpServletRequestWrapper {
    private final byte[] cachedBody;

    public CachedBodyHttpServletRequest(HttpServletRequest request) throws IOException {
        super(request);
        try(InputStream is = request.getInputStream(); ByteArrayOutputStream buffer = new ByteArrayOutputStream()){
            is.transferTo(buffer);
            this.cachedBody = buffer.toByteArray();
        }
    }

    @Override
    public ServletInputStream getInputStream() throws IOException{
        ByteArrayInputStream bais = new ByteArrayInputStream(cachedBody);
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return bais.available()==0;
            }

            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() throws IOException {
                return bais.read();
            }
        };
    }

    @Override
    public BufferedReader getReader() throws IOException{
        String enc = getCharacterEncoding() != null ? getCharacterEncoding() : "UTF-8";
        return new BufferedReader(new InputStreamReader(getInputStream(), enc));
    }

    public byte[] getCachedBody() {
        return cachedBody;
    }
}
