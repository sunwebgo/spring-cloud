package com.xha.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 订单表
 * @TableName payment
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    /**
     * ID
     */
    private Long id;

    /**
     * 流水号
     */
    private String serial;
}
