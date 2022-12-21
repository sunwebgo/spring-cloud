package com.xha.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigCenter3344Main {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenter3344Main.class,args);
    }
}
