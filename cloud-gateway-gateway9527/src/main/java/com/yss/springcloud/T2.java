package com.yss.springcloud;

import java.time.ZonedDateTime;

/**
 * @author: ymx
 * @date: 2022/9/2
 * @description:
 */
public class T2 {
    /**
     Route Predicate Factories这个是什么：
         Spring Cloud Gateway将路由匹配作为Spring WebFlux HandlerMapping基础架构的一部分。
         Spring Cloud Gateway包括许多内置的Route Predicate工厂。所有这些Predicate都与HTTP请求的不同属性匹配。多个RoutePredicate工厂可以进行组合。
         Spring Cloud Gateway创建Route 对象时，使用RoutePredicateFactory 创建 Predicate对象，Predicate 对象可以赋值给Route。Spring Cloud Gateway包含许多内置的Route Predicate Factories。
         所有这些谓词都匹配HTTP请求的不同属性。多种谓词工厂可以组合，并通过逻辑and。
     常用的Route Predicate Factory：
         The After Route Predicate Factory
         The Before Route Predicate Factory
         The Between Route Predicate Factory
         The Cookie Route Predicate Factory
         The Header Route Predicate Factory
         The Host Route Predicate Factory
         The Method Route Predicate Factory
         The Path Route Predicate Factory
         The Query Route Predicate Factory
         The RemoteAddr Route Predicate Factory
         The weight Route Predicate Factory
     */
    public static void main(String[] args) {
        //可以通过下述方法获得上述格式的时间戳字符串
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);
        //2022-09-02T11:13:03.766+08:00[Asia/Shanghai]
    }

    /**
     # 该命令相当于发get请求，且没带cookie
     curl http://localhost:9527/payment/lb
     # 带cookie的
     curl http://localhost:9527/payment/lb --cookie "chocolate=chip"
     */
}
