package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wxz
 * @Date: 2022/9/25 12:15
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    /**
     * @Title: getConfigInfo
     * @Description: getConfigInfo
     * @return: String返回类型
     * @Author: wxz
     * @Date: 2022/9/25 12:17
     */
    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }
}
