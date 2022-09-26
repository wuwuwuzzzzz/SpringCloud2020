package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wxz
 * @Date: 2022/9/15 15:18
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    /**
     * @Title: insert
     * @Description: insert
     * @Param: payment
     * @return: int返回类型
     * @Author: wxz
     * @Date: 2022/9/15 15:19
     */
    @Override
    public int insert(Payment payment) {
        return paymentDao.insert(payment);
    }

    /**
     * @Title: getPaymentById
     * @Description: select
     * @Param: id
     * @return: Payment返回类型
     * @Author: wxz
     * @Date: 2022/9/15 15:19
     */
    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
