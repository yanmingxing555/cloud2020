package com.yss.springcloud;

import com.yss.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author: ymx
 * @date: 2022/8/29
 * @version: 1.0.0.0
 */
@SpringBootApplication
@EnableEurekaClient
//在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效，形如
@RibbonClient(name = "cloud-payment-service",configuration = MySelfRule.class)
public class ConsumerOrderMain8090 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderMain8090.class,args);
    }
}
