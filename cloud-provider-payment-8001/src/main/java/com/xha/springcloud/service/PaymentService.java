package com.xha.springcloud.service;

import com.xha.springcloud.entities.Payment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Tony贾维斯
* @description 针对表【payment(订单表)】的数据库操作Service
* @createDate 2022-11-03 17:15:10
*/
public interface PaymentService extends IService<Payment> {
    /**
     * 创建流水订单
     * @param payment
     * @return
     */
    public int createPayment(Payment payment);

    /**
     * 根据id查询流水账单
     * @param id
     * @return
     */
    public Payment getPaymentById(Long id);
}
