package com.ojtbank.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {
        "com.ojtbank.api",
        "com.ojtbank.domain",
        "com.ojtbank.common"
})
@MapperScan("com.ojtbank.domain.mapper")
@EnableJpaRepositories(basePackages = "com.ojtbank.domain.repository")
@EntityScan(basePackages = "com.ojtbank.domain.model")
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}