package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: wxz
 * @Date: 2022/9/25 11:24
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacosMain83 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosMain83.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                " ______         _______    \n" +
                "|    _ `''.    /   __  \\   \n" +
                "| _ | ) _  \\  | ,_/  \\__)  \n" +
                "|( ''_'  ) |,-./  )        \n" +
                "| . (_) `. |\\  '_ '`)      \n" +
                "|(_    ._) ' > (_)  )  __  \n" +
                "|  (_.\\.' / (  .  .-'_/  ) \n" +
                "|       .'   `-'`-'     /  \n" +
                "'-----'`       `._____.'   \n" +
                "                          "
        );
    }
}
