package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: wxz
 * @Date: 2022/9/21 14:51
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWayMain9527 {
    public static void main(String[] args) {
        SpringApplication.run(GateWayMain9527.class, args);
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
