package com.atguigu.sprinfcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author: wxz
 * @Date: 2022/9/20 14:20
 */
@Component
public class PaymentFallBackService implements PaymentHystrixService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "PaymentFallBackService fallback";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "PaymentFallBackService fallback";
    }
}
