package com.xha.springcloud.service;

public interface HystrixService {
    String paymentNormal(Integer id);

    String paymentTimeout(Integer id);

    String paymentCircuitBreaker(Integer id);

}
