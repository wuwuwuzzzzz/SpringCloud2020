package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wxz
 * @date 16:24 2022/9/29
 */
@Mapper
public interface OrderDao {

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
