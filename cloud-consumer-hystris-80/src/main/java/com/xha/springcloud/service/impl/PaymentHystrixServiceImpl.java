package com.xha.springcloud.service.impl;

import com.xha.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentNormal(Integer id) {
        return "客户端服务降级，方法名为”paymentNormal“，" + "，id:" + id;
    }

    @Override
    public String paymentTimeout(Integer id) {
        return "客户端服务降级，方法名:" + "，id:" + id;
    }
}
