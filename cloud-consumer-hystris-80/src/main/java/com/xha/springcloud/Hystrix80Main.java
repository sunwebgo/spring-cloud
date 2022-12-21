package com.xha.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class Hystrix80Main {
    public static void main(String[] args) {
        SpringApplication.run(Hystrix80Main.class,args);
    }
}
