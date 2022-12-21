package com.xha.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@MapperScan("com.xha.springcloud.mapper")
@SpringBootApplication
@EnableEurekaClient
public class Payment8002Main {
    public static void main(String[] args) {
        SpringApplication.run(Payment8002Main.class, args);
    }
}
