package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wxz
 * @Date: 2022/9/15 15:20
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * @Title: insert
     * @Description: insert
     * @Param: payment
     * @return: CommonResult返回类型
     * @Author: wxz
     * @Date: 2022/9/15 15:21
     */
    @PostMapping("/payment/insert")
    public CommonResult insert(@RequestBody Payment payment) {
        int result = paymentService.insert(payment);
        log.info("插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入成功, serverPort:" + serverPort, result);
        } else {
            return new CommonResult(444, "插入失败", null);
        }
    }

    /**
     * @Title: getPaymentById
     * @Description: select
     * @Param: payment
     * @return: CommonResult返回类型
     * @Author: wxz
     * @Date: 2022/9/15 15:34
     */
    @GetMapping("/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功, serverPort:" + serverPort, payment);
        } else {
            return new CommonResult(444, "查询失败：" + id, null);
        }
    }

    /**
     * @Title: discovery
     * @Description:
     * @return: Object返回类型
     * @Author: wxz
     * @Date: 2022/9/19 16:39
     */
    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        for (String element : list) {
            log.info("element:" + element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return discoveryClient;
    }

    /**
     * @Title: getPaymentLB
     * @Description:
     * @return: String返回类型
     * @Author: wxz
     * @Date: 2022/9/19 16:40
     */
    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    /**
     * @Title: paymentFeignTimeout
     * @Description: Feign超时
     * @return: String返回类型
     * @Author: wxz
     * @Date: 2022/9/20 11:47
     */
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
