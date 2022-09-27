package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wxz
 * @Date: 2022/9/26 16:06
 */
@RestController
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
}
