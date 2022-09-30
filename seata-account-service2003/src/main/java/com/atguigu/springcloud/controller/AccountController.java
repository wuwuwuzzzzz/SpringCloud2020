package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author wxz
 * @date 09:50 2022/9/30
 */
@RestController
@Slf4j
public class AccountController {

    @Resource
    private AccountService accountService;

    /**
     * 扣减账户余额
     * @author wxz
     * @date 10:06 2022/9/30
     * @param userId
     * @param money
     * @return com.atguigu.springcloud.entities.CommonResult
     */
    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult<>(200, "扣减账户余额成功！");
    }
}
