package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @author wxz
 * @date 17:14 2022/9/29
 */
public interface OrderService {

    /**
     * 新建订单
     * @author wxz
     * @date 17:01 2022/9/29
     * @param order
     */
    void create(Order order);

    /**
     * 修改订单
     * @author wxz
     * @date 17:02 2022/9/29
     * @param userId
     * @param status
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
