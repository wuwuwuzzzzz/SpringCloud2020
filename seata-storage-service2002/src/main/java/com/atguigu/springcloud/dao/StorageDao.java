package com.atguigu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wxz
 * @date 09:32 2022/9/30
 */
@Mapper
public interface StorageDao {

    /**
     * 扣减库存
     * @author wxz
     * @date 09:37 2022/9/30
     * @param productId
     * @param count
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
