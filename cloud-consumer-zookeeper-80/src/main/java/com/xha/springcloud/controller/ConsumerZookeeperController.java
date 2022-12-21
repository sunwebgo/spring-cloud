package com.xha.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class ConsumerZookeeperController {

    public static final String URL = "http://cloud-provider-payment-zookeeper-8003";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/zookeeper")
    public String getZookeeper() {
        return restTemplate.getForObject(URL + "/payment/zookeeper", String.class);
    }
}
