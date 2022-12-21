package com.xha.springcloud.controller;


import com.xha.springcloud.entities.CommonResult;
import com.xha.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/consumer")
public class ConsumerController {


//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PROVIDER-SERVER";

    @Resource
    private RestTemplate restTemplate;

    /**
     * 创建订单
     * @param payment
     * @return
     */
    @PostMapping("/createPayment")
    public CommonResult<Payment> createPayment(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/createPayment",payment,CommonResult.class);
    }

    /**
     * 查询订单
     * @param id
     * @return
     */
    @GetMapping("/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/getPaymentById/" + id,CommonResult.class);
    }
}
