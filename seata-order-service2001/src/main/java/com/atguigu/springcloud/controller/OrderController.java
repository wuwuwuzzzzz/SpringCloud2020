package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.domain.Order;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wxz
 * @date 09:19 2022/9/30
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 创建订单
     * @author wxz
     * @date 09:22 2022/9/30
     * @param order
     * @return com.atguigu.springcloud.entities.CommonResult
     */
    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new  CommonResult(200, "创建成功！");
    }
}
