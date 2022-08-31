package com.yss.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: ymx
 * @date: 2022/8/29
 * @description: 配置类
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    //若调用服务有多台，并且请求服务名称，则必须开启负载均衡
    //并且启动类配置RibbonClient(name = "cloud-payment-service",configuration = MySelfRule.class)，
    //@LoadBalanced //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
