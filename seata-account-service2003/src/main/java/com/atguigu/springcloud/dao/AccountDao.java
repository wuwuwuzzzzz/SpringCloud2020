package com.atguigu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author wxz
 * @date 16:24 2022/9/29
 */
@Mapper
public interface AccountDao {

    /**
     * 扣减账户余额
     * @author wxz
     * @date 09:58 2022/9/30
     * @param userId
     * @param money
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
