package com.xha.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xha.springcloud.service.PaymentHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "globalPaymentTimeoutHandler")
public class HystrixConsumerController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/hystrix/normal/{id}")
    public String paymentNormal(@PathVariable Integer id){
        return paymentHystrixService.paymentNormal(id);
    }

    @GetMapping("/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeoutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
//    })
    @HystrixCommand
    public String paymentTimeout(@PathVariable Integer id){
        return paymentHystrixService.paymentTimeout(id);
    }

    public String paymentTimeoutHandler(Integer id){
        return "客户端服务降级 id:" + id;
    }

    /**
     * 全局服务降级方法
     *
     * @return {@link String}
     */
    public String globalPaymentTimeoutHandler(){
        return "客户端全局服务降级";
    }
}
