package com.atguigu.sprinfcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: wxz
 * @Date: 2022/9/20 14:20
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE", fallback = PaymentFallBackService.class)
public interface PaymentHystrixService {

    /**
     * @Title: paymentInfoOk
     * @Description: ok
     * @Param: id
     * @return: String返回类型
     * @Author: wxz
     * @Date: 2022/9/20 14:23
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id);

    /**
     * @Title: paymentInfoTimeout
     * @Description: timeout
     * @Param: id
     * @return: String返回类型
     * @Author: wxz
     * @Date: 2022/9/20 14:24
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id);
}
