package com.yss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: ymx
 * @date: 2022/8/30
 * @description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMainZK8090 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainZK8090.class,args);
    }
}
