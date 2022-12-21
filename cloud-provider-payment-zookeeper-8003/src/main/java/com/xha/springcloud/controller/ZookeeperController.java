package com.xha.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class ZookeeperController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/zookeeper")
    public String getZookeeperInfo(){
        return "springCloud with zookeeper: "+serverPort+"\t"+ UUID.randomUUID();
    }

}
