package com.yss.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: ymx
 * @date: 2022/9/2
 * @description: 也可以通过代码配置实现路由功能
 */
@Configuration
public class GateWayConfig {
    /**
     * 配置了一个id为route-name的路由规则，
     * 当访问地址 http://localhost:9527/guonei时会自动转发到地址：http://news.baidu.com/guonei
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_yss01",//id
                r -> r.path("/guonei").uri("http://news.baidu.com/guonei"))//路径映射
              .route("path_route_yss02",
                r -> r.path("/guoji").uri("http://news.baidu.com/guoji"))
              .build();
        return routes.build();
    }
}
