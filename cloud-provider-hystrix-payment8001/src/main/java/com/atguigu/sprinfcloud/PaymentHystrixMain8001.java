package com.atguigu.sprinfcloud;

import com.netflix.hystrix.HystrixMetrics;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

/**
 * @Author: wxz
 * @Date: 2022/9/15 14:35
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class, args);
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
    
    /** 
     * @Title: getServlet
     * @Description: 
     * @return: ServletRegistrationBean返回类型
     * @Author: wxz
     * @Date: 2022/9/21 11:25
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
