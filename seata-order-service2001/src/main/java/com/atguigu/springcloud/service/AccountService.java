package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author wxz
 * @date 17:17 2022/9/29
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    /**
     * 账户开始做扣减
     * @author wxz
     * @date 17:28 2022/9/29
     * @param userId
     * @param money
     * @return com.atguigu.springcloud.entities.CommonResult
     */
    @PostMapping("/account/dectease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
