package com.atguigu.springcloud.service;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author wxz
 * @date 09:43 2022/9/30
 */
public interface AccountService {

    /**
     * 扣减账户余额
     * @author wxz
     * @date 09:58 2022/9/30
     * @param userId
     * @param money
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
