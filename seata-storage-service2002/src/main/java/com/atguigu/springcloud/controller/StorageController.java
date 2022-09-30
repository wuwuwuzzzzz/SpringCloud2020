package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wxz
 * @date 09:50 2022/9/30
 */
@RestController
@Slf4j
public class StorageController {

    @Resource
    private StorageService storageService;

    /**
     * 扣减库存
     * @author wxz
     * @date 09:52 2022/9/30
     * @param productId
     * @param count
     * @return com.atguigu.springcloud.entities.CommonResult
     */
    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult<>(200, "扣减库存成功！");
    }
}
