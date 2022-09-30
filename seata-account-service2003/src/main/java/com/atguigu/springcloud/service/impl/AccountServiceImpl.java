package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.AccountDao;
import com.atguigu.springcloud.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author wxz
 * @date 09:46 2022/9/30
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Resource
    private AccountDao accountDao;


    /**
     * 扣减账户余额
     * @author wxz
     * @date 10:04 2022/9/30
     * @param userId
     * @param money
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {
        LOGGER.info("storage service 开始扣减账户余额");
        accountDao.decrease(userId, money);
        LOGGER.info("storage service 结束扣减账户余额");
    }
}
