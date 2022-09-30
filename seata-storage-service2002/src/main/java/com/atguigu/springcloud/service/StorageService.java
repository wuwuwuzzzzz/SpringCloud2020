package com.atguigu.springcloud.service;

/**
 * @author wxz
 * @date 09:43 2022/9/30
 */
public interface StorageService {

    /**
     * 扣减库存
     * @author wxz
     * @date 09:44 2022/9/30
     * @param productId
     * @param count
     */
    void decrease(Long productId, Integer count);
}
