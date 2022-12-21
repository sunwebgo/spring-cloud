package com.xha.springcloud.controller;

import com.xha.springcloud.service.HystrixService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/payment")
public class HystrixController {

    @Resource
    private HystrixService hystrixService;

    @GetMapping("/hystrix/normal/{id}")
    public String paymentNormal(@PathVariable Integer id){
        return hystrixService.paymentNormal(id);
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String paymentTimeout(@PathVariable Integer id){
        return hystrixService.paymentTimeout(id);
    }

    /**
     * 服务熔断
     *
     * @param id id
     * @return {@link String}
     */
    @GetMapping("/hystrix/circuit/{id}")
    public String paymentCircuit(@PathVariable Integer id){
        return hystrixService.paymentCircuitBreaker(id);
    }
}
