package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: wxz
 * @Date: 2022/9/20 11:18
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    /**
     * @Title: getPaymentById
     * @Description: select
     * @Param: id
     * @return: CommonResult返回类型
     * @Author: wxz
     * @Date: 2022/9/20 11:49
     */
    @GetMapping("/consumer/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    /**
     * @Title: paymentFeignTimeout
     * @Description: Feign超时
     * @return: String返回类型
     * @Author: wxz
     * @Date: 2022/9/20 11:49
     */
    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // open-feign-ribbon,客户端一般默认等待1秒钟
        return paymentFeignService.paymentFeignTimeout();
    }
}
