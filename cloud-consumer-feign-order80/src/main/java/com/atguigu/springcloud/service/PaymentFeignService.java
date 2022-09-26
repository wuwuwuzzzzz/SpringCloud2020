package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: wxz
 * @Date: 2022/9/20 11:13
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    /** 
     * @Title: getPaymentById
     * @Description: 
     * @Param: id
     * @return: CommonResult返回类型
     * @Author: wxz
     * @Date: 2022/9/20 11:46
     */
    @GetMapping("/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    /**
     * @Title: paymentFeignTimeout
     * @Description: Feign超时
     * @return: String返回类型
     * @Author: wxz
     * @Date: 2022/9/20 11:49
     */
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();
}
