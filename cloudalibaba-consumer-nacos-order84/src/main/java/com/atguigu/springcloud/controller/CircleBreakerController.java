package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 *
 * @author wxz
 * @date 11:12 2022/9/29
 */
@RestController
@Slf4j
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private PaymentService paymentService;

    @Resource
    private RestTemplate restTemplate;

    /**
     *
     * @author wxz
     * @date 11:20 2022/9/29
     * @param id
     * @return com.atguigu.springcloud.entities.CommonResult<com.atguigu.springcloud.entities.Payment>
     */
    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback") //没有配置
//    @SentinelResource(value = "fallback", fallback = "handlerFallBack") // fallback只负责业务异常
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler") // blockHandler只负责sentinel控制台配置违规
    @SentinelResource(value = "fallback", fallback = "handlerFallBack", blockHandler = "blockHandler")
    public CommonResult<Payment> fallBack(@PathVariable("id") Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("非法参数异常！");
        } else if (result.getData() == null) {
            throw new NullPointerException("空指针异常！");
        }
        return result;
    }

    /**
     *
     * @author wxz
     * @date 11:42 2022/9/29
     * @param id
     * @param e
     * @return com.atguigu.springcloud.entities.CommonResult
     */
    public CommonResult handlerFallBack(@PathVariable("id") Long id, Throwable e) {
        Payment payment = new Payment(id, null);
        return new CommonResult(444, "fallBack" + e.getMessage(), payment);
    }

    /**
     *
     * @author wxz
     * @date 11:51 2022/9/29
     * @param id
     * @param e
     * @return com.atguigu.springcloud.entities.CommonResult
     */
    public CommonResult blockHandler(@PathVariable("id") Long id, BlockException e) {
        Payment payment = new Payment(id, null);
        return new CommonResult(445, "blockHandler" + e.getMessage(), payment);
    }

    /**
     *
     * @author wxz
     * @date 12:13 2022/9/29
     * @param id
     * @return com.atguigu.springcloud.entities.CommonResult<com.atguigu.springcloud.entities.Payment>
     */
    @GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }
}
