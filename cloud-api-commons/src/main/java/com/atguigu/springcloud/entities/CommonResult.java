package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: wxz
 * @Date: 2022/9/15 14:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    /** 状态码 */
    private Integer code;

    /** 返回内容 */
    private String msg;

    /** 数据对象 */
    private T data;

    public CommonResult(Integer code, String msg) {
        this(code, msg, null);
    }
}
