package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.myhandler.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wxz
 * @date 10:17 2022/9/29
 */
@RestController
@Slf4j
public class RateLimitController {

    /**
     * @return com.atguigu.springcloud.entities.CommonResult
     * @author wxz
     * @date 10:26 2022/9/29
     */
    @GetMapping("byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试～", new Payment(2020L, "serial001"));
    }

    /**
     * @param e
     * @return com.atguigu.springcloud.entities.CommonResult
     * @author wxz
     * @date 10:26 2022/9/29
     */
    public CommonResult handleException(BlockException e) {
        return new CommonResult(444, e.getClass().getCanonicalName() + "\t 服务不可用!");
    }

    /**
     * @return com.atguigu.springcloud.entities.CommonResult
     * @author wxz
     * @date 10:30 2022/9/29
     */
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "/byUrl")
    public CommonResult buUrl() {
        return new CommonResult(200, "测试url限流测试～", new Payment(2020L, "serial002"));
    }

    /**
     * 
     * @author wxz
     * @date 10:35 2022/9/29
     * @return com.atguigu.springcloud.entities.CommonResult
     */
    @GetMapping("/rateLimit/customerBlockHandle")
    @SentinelResource(value = "/customerBlockHandle", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException")
    public CommonResult customBlockHandle() {
        return new CommonResult(200, "customerBlockHandle～", new Payment(2020L, "serial003"));
    }
}
