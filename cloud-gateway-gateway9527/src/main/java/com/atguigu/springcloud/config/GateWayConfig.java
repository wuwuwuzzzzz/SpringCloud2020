package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: wxz
 * @Date: 2022/9/21 15:37
 */
@Configuration
public class GateWayConfig {
    /** 
     * @Description: 配置了一个id为path_route_atguigu的路由，
     * 当访问地址为http://localhost:9527//guonei时会自动转发地址http://news.baidu.com/guonei
     * @Author: wxz
     * @Date: 2022/9/21 15:44
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_atguigu",
                r -> r.path("/guonei")
                        .uri("https://baijiahao.baidu.com/s?id=1743125360152199139")).build();
        return routes.build();
    }
}
