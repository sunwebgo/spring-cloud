package com.xha.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@MapperScan("com.xha.springcloud.mapper")
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class Payment8001Main {
    public static void main(String[] args) {
        SpringApplication.run(Payment8001Main.class, args);
    }
}
