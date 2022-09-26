package com.atguigu.sprinfcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wxz
 * @Date: 2022/9/20 13:32
 */
@Service
public class PaymentService {

    /**
     * @Title: paymentInfo_OK
     * @Description: 正常访问
     * @Param: id
     * @return: String返回类型
     * @Author: wxz
     * @Date: 2022/9/20 13:33
     */
    public String paymentInfoOK(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_OK,id " + id + "\t" + "哈哈哈";
    }

    /**
     * @Title: paymentInfo_Timeout
     * @Description: 异常情况下
     * @Param: id
     * @return: String返回类型
     * @Author: wxz
     * @Date: 2022/9/20 13:35
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoTimeout(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = 0;
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_Timeout,id " + id + "\t" + "哈哈哈耗时3秒钟";
    }

    /**
     * @Title: paymentInfoTimeoutHandler
     * @Description: fallback方法
     * @Param: id
     * @return: String返回类型
     * @Author: wxz
     * @Date: 2022/9/20 17:46
     */
    public String paymentInfoTimeoutHandler(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "系统繁忙 请稍后再试 " + id + "\t" + "呜呜呜 出错了！";
    }

    /**
     * @Title: paymentCircuitBreaker
     * @Description: 服务熔断
     * @Param: id
     * @return: String返回类型
     * @Author: wxz
     * @Date: 2022/9/21 09:29
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallBack", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号: " + serialNumber;
    }

    /**
     * @Title: paymentCircuitBreakerFallBack
     * @Description: fallback
     * @Param: id
     * @return: String返回类型
     * @Author: wxz
     * @Date: 2022/9/21 09:29
     */
    public String paymentCircuitBreakerFallBack(@PathVariable("id") Integer id) {
        return "id不能为负数。请稍后再试～";
    }
}
