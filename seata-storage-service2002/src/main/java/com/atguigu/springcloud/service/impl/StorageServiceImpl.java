package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.StorageDao;
import com.atguigu.springcloud.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wxz
 * @date 09:46 2022/9/30
 */
@Service
public class StorageServiceImpl implements StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Resource
    private StorageDao storageDao;


    /**
     * 扣减库存
     * @author wxz
     * @date 09:49 2022/9/30
     * @param productId
     * @param count
     */
    @Override
    public void decrease(Long productId, Integer count) {
        LOGGER.info("storage service 开始扣减库存");
        storageDao.decrease(productId, count);
        LOGGER.info("storage service 结束扣减库存");
    }
}
