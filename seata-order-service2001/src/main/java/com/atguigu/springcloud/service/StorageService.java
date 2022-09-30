package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wxz
 * @date 17:17 2022/9/29
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    /**
     * 减少订单库存
     * @author wxz
     * @date 17:25 2022/9/29
     * @param productId
     * @param count
     * @return com.atguigu.springcloud.entities.CommonResult
     */
    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
