package com.xha.springcloud.controller;


import com.xha.springcloud.entities.CommonResult;
import com.xha.springcloud.entities.Payment;
import com.xha.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String portValue;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/createPayment")
    public CommonResult createPayment(@RequestBody Payment payment) {
        int result = paymentService.createPayment(payment);
        log.info("添加的结果：" + result);
        if (result == 0) {
            return new CommonResult(400, "插入数据库失败！");
        }
        return new CommonResult(200, "插入数据库成功。");
    }

    @GetMapping("/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment == null) {
            return new CommonResult(400, "查询失败！");
        }
        return new CommonResult(200, "查询成功。当前的微服务模块端口为：" + portValue, payment);
    }

    @GetMapping(value = "/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service:" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVER");
        for (ServiceInstance instance : instances) {
            log.info("instance:" + instance.getServiceId()
                    + "\t" + instance.getHost()
                    + "\t" + instance.getPort()
                    + "\t" + instance.getUri());
        }
        return discoveryClient;
    }

    @GetMapping("/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return portValue;
    }
}
