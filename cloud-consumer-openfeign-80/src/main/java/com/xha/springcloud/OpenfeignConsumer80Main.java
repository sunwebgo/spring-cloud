package com.xha.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OpenfeignConsumer80Main {
    public static void main(String[] args) {
        SpringApplication.run(OpenfeignConsumer80Main.class,args);
    }
}
