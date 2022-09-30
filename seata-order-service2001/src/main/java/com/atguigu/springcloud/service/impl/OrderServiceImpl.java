package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.OrderDao;
import com.atguigu.springcloud.domain.Order;
import com.atguigu.springcloud.service.AccountService;
import com.atguigu.springcloud.service.OrderService;
import com.atguigu.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wxz
 * @date 17:15 2022/9/29
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    /**
     * 新建
     * @author wxz
     * @date 17:18 2022/9/29
     * @param order
     */
    @GlobalTransactional(name = "order-create", rollbackFor = Exception.class)
    @Override
    public void create(Order order) {

        log.info("----------------开始新建订单-----------");
        orderDao.create(order);

        log.info("----------------订单服务开始调用库存-count----------");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("----------------订单开始做扣减end-----------");

        log.info("----------------账户开始扣钱-money----------");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("----------------账户扣钱end-----------");

        log.info("------修改订单状态开始-----");
        orderDao.update(order.getUserId(), 0);
        log.info("------修改订单结束---------");

        log.info("结束啦！");
    }

    /**
     * 修改
     * @author wxz
     * @date 17:18 2022/9/29
     * @param userId
     * @param status
     */
    @Override
    public void update(Long userId, Integer status) {
//        orderDao.update();
    }
}
