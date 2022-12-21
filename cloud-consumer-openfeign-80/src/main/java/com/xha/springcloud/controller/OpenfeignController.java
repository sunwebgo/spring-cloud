package com.xha.springcloud.controller;

import com.xha.springcloud.entities.CommonResult;
import com.xha.springcloud.entities.Payment;
import com.xha.springcloud.service.ProviderFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class OpenfeignController {

    @Resource
    private ProviderFeignService providerFeignService;

    @GetMapping("/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return providerFeignService.getPaymentById(id);
    }

    @GetMapping("/paymentFeignTimeout")
    public String paymentFeignTimeout(){
        return providerFeignService.paymentFeignTimeout();
    }
}
