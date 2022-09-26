package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Author: wxz
 * @Date: 2022/9/16 16:46
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * @Title: create
     * @Description: create
     * @Param: payment
     * @return: Payment>返回类型
     * @Author: wxz
     * @Date: 2022/9/20 10:33
     */
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/insert", payment, CommonResult.class);
    }

    /**
     * @Title: getPayment
     * @Description: select
     * @Param: id
     * @return: Payment>返回类型
     * @Author: wxz
     * @Date: 2022/9/20 10:33
     */
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/getPaymentById/" + id, CommonResult.class);
    }

    /**
     * @Title: getPayment2
     * @Description: 测试getForEntity
     * @Param: id
     * @return: Payment>返回类型
     * @Author: wxz
     * @Date: 2022/9/20 10:33
     */
    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/getPaymentById/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            log.info(entity.getBody().toString());
            log.info(entity.getHeaders().toString());
            return entity.getBody();
        } else {
            return new CommonResult<>(444, "操作失败");
        }
    }

    /**
     * @Title: getPaymentLb
     * @Description: 手写负载均衡
     * @return: String返回类型
     * @Author: wxz
     * @Date: 2022/9/20 10:34
     */
    @GetMapping("/consumer/payment/lb")
    public String getPaymentLb() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }

        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }

    /** 
     * @Title: paymentZipkin
     * @Description: 
     * @return: String返回类型
     * @Author: wxz
     * @Date: 2022/9/24 19:06
     */
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin() {
        String result = restTemplate.getForObject("http://localhost:8007" + "/payment/zipkin", String.class);
        return result;
    }
}
