package com.xha.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xha.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Tony贾维斯
* @description 针对表【payment(订单表)】的数据库操作Mapper
* @createDate 2022-11-03 17:15:10
* @Entity com.xha.springcloud.entities.Payment
*/

@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {
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




