package com.xha.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DashBoard9001Main {
    public static void main(String[] args) {
        SpringApplication.run(DashBoard9001Main.class,args);
    }
}
