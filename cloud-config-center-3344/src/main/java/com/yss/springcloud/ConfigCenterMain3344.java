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

    /**
     SpringCloud Bus动态刷新全局广播：
        curl -X POST "http://localhost:3344/actuator/bus-refresh"
     SpringCloud Bus动态刷新定点通知：指定具体某一个实例生效而不是全部
        /bus/refresh请求不再发送到具体的服务实例上，而是发给config server并通过destination参数类指定需要更新配置的服务或实例
        公式：http://localhost:配置中心的端口号/actuator/bus-refresh/{destination}
        curl -X POST "http://localhost:3344/actuator/bus-refresh/config-client:3355"
     */
}
