package com.atguigu.sprinfcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description: EnableDiscoveryClient用于向使用consul或者zookeeper作为注册中心时注册服务
 * @Author: wxz
 * @Date: 2022/9/19 09:44
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class PaymentMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8006.class, args);
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
