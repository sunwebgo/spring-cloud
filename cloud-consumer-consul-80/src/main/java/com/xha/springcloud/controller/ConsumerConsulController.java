package com.xha.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class ConsumerConsulController {

    public static final String URL = "http://cloud-provider-payment-consul-8004";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consul")
    public String getConsulInfo(){
        return restTemplate.getForObject(URL + "/payment/consul",String.class);
    }

}
