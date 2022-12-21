package com.xha.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerZookeeper80Main {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerZookeeper80Main.class,args);
    }
}
