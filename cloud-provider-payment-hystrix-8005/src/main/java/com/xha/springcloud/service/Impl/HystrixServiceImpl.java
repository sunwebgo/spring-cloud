package com.xha.springcloud.service.Impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xha.springcloud.service.HystrixService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class HystrixServiceImpl implements HystrixService {
    @Override
    public String paymentNormal(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "payment_normal,id:" + id;
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentTimeout(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "payment_timeout,id:" + id;
    }

    public String paymentTimeoutHandler(Integer id) {
        return "服务端服务降级 id:" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启熔断器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") //失败率达到多少后跳闸
//            在10秒中的时间窗口期，在10次访问中如果失败率达到60%就进行服务熔断
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("当前id为：" + id + "，id不能为负数");
        }
        String uuid = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号为：" + uuid;
    }

    public String paymentCircuitBreakerFallback(@PathVariable("id") Integer id) {
        return "id不能为负数";
    }
}
