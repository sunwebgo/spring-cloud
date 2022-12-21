package com.xha.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class ConsulController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consul")
    public String paymentInfo()
    {
        return "springcloud with consul: "+serverPort+"\t\t"+ UUID.randomUUID();
    }
}
