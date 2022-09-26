package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: wxz
 * @Date: 2022/9/15 14:35
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
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
