package com.atguigu.payment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @Author: wxz
 * @Date: 2022/9/15 15:20
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/zk")
    public String paymentzk() {
        return "springcloud with zookeeper" + serverPort + "\t" + UUID.randomUUID().toString();
    }

}
