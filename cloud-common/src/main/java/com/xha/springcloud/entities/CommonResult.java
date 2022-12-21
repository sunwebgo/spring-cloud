package com.xha.springcloud.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * JSON封装体CommonResult
 */
@Data
@NoArgsConstructor
public class CommonResult<T> {
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 返回的数据
     */
    private T data;

    /**
     * 不含data的有参构造
     */
    public CommonResult(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    /**
     * 含有data的有参构造
     */
    public CommonResult(Integer code,String message,T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
