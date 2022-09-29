package com.atguigu.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 *
 * @author wxz
 * @date 10:37 2022/9/29
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException e) {
        return new CommonResult(4444, "自定义！");
    }
}
