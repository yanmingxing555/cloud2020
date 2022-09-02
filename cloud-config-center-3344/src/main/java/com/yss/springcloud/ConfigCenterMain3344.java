package com.yss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author: ymx
 * @date: 2022/9/2
 * @description: 配置中心
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigCenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class,args);
    }
    /**
     重要配置细节总结
         /{name}-{profiles}.yml
         /{label}-{name}-{profiles}.yml
         label：分支(branch)
         name：服务名
         profiles：环境(dev/test/prod)
     */
}
