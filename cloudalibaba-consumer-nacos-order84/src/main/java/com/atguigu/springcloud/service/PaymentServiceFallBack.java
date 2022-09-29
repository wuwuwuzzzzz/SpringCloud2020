package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 *
 * @author wxz
 * @date 12:07 2022/9/29
 */
@Component
public class PaymentServiceFallBack implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444, "服务降级返回～", new Payment(id, "error"));
    }
}
