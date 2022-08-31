package com.yss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: ymx
 * @date: 2022/8/31
 * @description:
 */
@SpringBootApplication
@EnableFeignClients //即使此服务没有注册进Eureka，也可以使用，并且自带负载均衡
public class OrderFeignMain8090 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain8090.class,args);
    }
}
