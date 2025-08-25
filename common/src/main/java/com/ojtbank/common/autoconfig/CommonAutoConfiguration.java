package com.ojtbank.common.autoconfig;

import com.ojtbank.common.audit.AuditContextInterceptor;
import com.ojtbank.common.filter.RequestWrappingFilter;
import jakarta.servlet.FilterRegistration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@AutoConfiguration
public class CommonAutoConfiguration {

    @Bean
    public FilterRegistrationBean<RequestWrappingFilter> requestWrappingFilterRegistration(){
        FilterRegistrationBean<RequestWrappingFilter> reg = new FilterRegistrationBean<>();
        reg.setFilter(new RequestWrappingFilter());
        reg.addUrlPatterns("/*");
        reg.setOrder(0);
        return reg;
    }


    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new AuditContextInterceptor()).addPathPatterns("/**");
            }
        };
    }
}
