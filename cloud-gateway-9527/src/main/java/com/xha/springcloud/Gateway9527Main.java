package com.xha.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Gateway9527Main {
    public static void main(String[] args) {
        SpringApplication.run(Gateway9527Main.class,args);
    }
}
