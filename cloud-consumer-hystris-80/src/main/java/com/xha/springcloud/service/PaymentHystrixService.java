package com.xha.springcloud.service;

import com.xha.springcloud.service.impl.PaymentHystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentHystrixServiceImpl.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/normal/{id}")
    public String paymentNormal(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentTimeout(@PathVariable("id") Integer id);
}
