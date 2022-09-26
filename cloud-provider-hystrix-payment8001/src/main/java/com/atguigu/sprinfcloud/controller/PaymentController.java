package com.atguigu.sprinfcloud.controller;

import com.atguigu.sprinfcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: wxz
 * @Date: 2022/9/20 13:36
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("$server.port")
    private String serverPort;

    /**
     * @Title: paymentInfo_OK
     * @Description: OK
     * @Param: id
     * @return: String返回类型
     * @Author: wxz
     * @Date: 2022/9/20 13:40
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfoOK(id);
        log.info("result: " + result);
        return result;
    }

    /**
     * @Title: paymentInfo_Timeout
     * @Description: timeout
     * @Param: id
     * @return: String返回类型
     * @Author: wxz
     * @Date: 2022/9/20 13:40
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfoTimeout(id);
        log.info("result: " + result);
        return result;
    }

    /** 
     * @Title: paymentCircuitBreaker
     * @Description: 服务熔断
     * @Param: id
     * @return: String返回类型
     * @Author: wxz
     * @Date: 2022/9/21 09:48
     */
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("result: " + result);
        return result;
    }
}
