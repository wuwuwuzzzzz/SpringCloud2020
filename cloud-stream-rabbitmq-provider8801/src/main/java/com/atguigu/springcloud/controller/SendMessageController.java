package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wxz
 * @Date: 2022/9/23 15:44
 */
@RestController
public class SendMessageController {

    @Autowired
    private IMessageProvider messageProvider;

    /**
     * @Title: sendMessage
     * @Description: send
     * @return: String返回类型
     * @Author: wxz
     * @Date: 2022/9/23 15:45
     */
    @GetMapping("/sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }
}
