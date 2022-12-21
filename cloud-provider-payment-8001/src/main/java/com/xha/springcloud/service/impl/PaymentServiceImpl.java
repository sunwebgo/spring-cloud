package com.xha.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xha.springcloud.entities.Payment;
import com.xha.springcloud.mapper.PaymentMapper;
import com.xha.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Tony贾维斯
 * @description 针对表【payment(订单表)】的数据库操作Service实现
 * @createDate 2022-11-03 17:15:10
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment>
        implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int createPayment(Payment payment) {
        return paymentMapper.createPayment(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}




