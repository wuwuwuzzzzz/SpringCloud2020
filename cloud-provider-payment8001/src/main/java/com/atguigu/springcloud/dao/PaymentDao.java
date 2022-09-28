package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: wxz
 * @Date: 2022/9/15 14:58
 */
@Mapper
public interface PaymentDao {
    /**
     * add
     * @author wxz
     * @date 16:07 2022/9/28
     * @param payment
     * @return int
     */
    public int insert(Payment payment);


    /**
     * select
     * @author wxz
     * @date 16:06 2022/9/28
     * @param id
     * @return com.atguigu.springcloud.entities.Payment
     */
    public Payment getPaymentById(@Param("id") Long id);
}
