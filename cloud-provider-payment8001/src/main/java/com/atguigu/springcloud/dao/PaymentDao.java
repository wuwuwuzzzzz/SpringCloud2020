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
     * @Title: insert
     * @Description: add
     * @Param: payment
     * @return: int返回类型
     * @Author: wxz
     * @Date: 2022/9/15 15:00
     */
    public int insert(Payment payment);

    /**
     * @Title: getPaymentById
     * @Description: select
     * @Param: id
     * @return: Payment返回类型
     * @Author: wxz
     * @Date: 2022/9/15 15:00
     */
    public Payment getPaymentById(@Param("id") Long id);
}
