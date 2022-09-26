package com.atguigu.sprinfcloud.controller;

import com.atguigu.sprinfcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: wxz
 * @Date: 2022/9/20 14:19
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "paymentGlobalFallBackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    /**
     * @Title: paymentInfoOk
     * @Description: ok
     * @Param: id
     * @return: String返回类型
     * @Author: wxz
     * @Date: 2022/9/20 14:26
     */
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfoOk(id);
        return result;
    }

    /**
     * @Title: paymentInfoTimeout
     * @Description: timeout
     * @Param: id
     * @return: String返回类型
     * @Author: wxz
     * @Date: 2022/9/20 14:27
     */
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutFallBackMethod",commandProperties = {
////            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
////    })
    @HystrixCommand
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfoTimeout(id);
        return result;
    }

    /**
     * @Title: paymentInfoTimeoutFallBackMethod
     * @Description: fallback方法
     * @return: String返回类型
     * @Author: wxz
     * @Date: 2022/9/20 18:15
     */
    public String paymentInfoTimeoutFallBackMethod(@PathVariable("id") Integer id) {
        return "我是消费者80，对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己～";
    }

    /** 
     * @Title: paymentGlobalFallBackMethod
     * @Description: 全局fallbackmethod
     * @return: String返回类型
     * @Author: wxz
     * @Date: 2022/9/20 18:25
     */
    public String paymentGlobalFallBackMethod() {
        return "Global异常处理信息，请稍后再试～";
    }
}
