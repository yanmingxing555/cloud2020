package com.yss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: ymx
 * @date: 2022/9/1
 * @description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker//主启动类激活@HystrixCommand
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class,args);
    }
}
