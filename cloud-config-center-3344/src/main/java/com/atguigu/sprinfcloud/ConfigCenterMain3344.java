package com.atguigu.sprinfcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author: wxz
 * @Date: 2022/9/22 11:15
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class, args);
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
