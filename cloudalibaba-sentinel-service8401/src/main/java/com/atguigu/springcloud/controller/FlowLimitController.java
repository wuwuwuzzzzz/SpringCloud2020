package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wxz
 * @Date: 2022/9/26 16:06
 */
@RestController
@Slf4j
public class FlowLimitController {

    /**
     * @Title: testA
     * @Description: testA
     * @return: String返回类型
     * @Author: wxz
     * @Date: 2022/9/26 16:14
     */
    @GetMapping("/testA")
    public String testA() {
        return "testA";
    }

    /**
     * @Title: testB
     * @Description: testB
     * @return: String返回类型
     * @Author: wxz
     * @Date: 2022/9/26 16:14
     */
    @GetMapping("/testB")
    public String testB() {
        return "testB";
    }

    /**
     * test服务降级
     *
     * @return java.lang.String
     * @author wxz
     * @date 16:17 2022/9/28
     */
    @GetMapping("/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("testD 测试RT");
        return "testD";
    }

    /**
     * 异常数
     *
     * @return java.lang.String
     * @author wxz
     * @date 17:03 2022/9/28
     */
    @GetMapping("/testE")
    public String testE() {
        log.info("testE 测试异常数");
        int age = 10 / 0;
        return "testE 测试异常数";
    }

    /**
     * 热点限流
     * @author wxz
     * @date 17:17 2022/9/28
     * @param p1
     * @param p2
     * @return java.lang.String
     */
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealTestHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        int age = 10/0;
        return "test hot key";
    }

    /**
     * fallBackMethod
     * @author wxz
     * @date 17:20 2022/9/28
     * @param p1
     * @param p2
     * @param e
     * @return java.lang.String
     */
    public String dealTestHotKey(String p1, String p2, BlockException e) {
        return "dealTestHotKey";
    }
}
