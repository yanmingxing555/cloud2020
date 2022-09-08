package com.yss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: ymx
 * @date: 2022/9/7
 * @description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigClientMain3377 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientMain3377.class,args);
    }
    /**
     Nacos中的dataid的组成格式及与SpringBoot配置文件中的匹配规则：
        ${spring.application.name}-${spring.profiles.active}.${spring.cloud.nacos.config.file-extension}
        prefix 默认为 spring.application.name 的值
        spring.profile.active 即为当前环境对应的 profile，可以通过配置项 spring.profile.active 来配置。
        file-exetension 为配置内容的数据格式，可以通过配置项 spring.cloud.nacos.config.file-extension 来配置
     默认保留：
        Nacos会记录配置文件的历史版本默认保留30天，此外还有一键回滚功能，回滚操作将会触发配置更新
     */
    /**
     默认情况：Namespace=public，Group=DEFAULT_GROUP，默认Cluster是DEFAULT
        Nacos默认的Namespace是public，Namespace主要用来实现隔离。
            比方说我们现在有三个环境：开发、测试、生产环境，我们就可以创建三个Namespace，不同的Namespace之间是隔离的。
        Group默认是DEFAULT_GROUP，Group可以把不同的微服务划分到同一个分组里面去
        Service就是微服务:一个Service可以包含多个Cluster (集群)，Nacos默认Cluster是DEFAULT，Cluster是对指定微服务的一个虚拟划分。
            比方说为了容灾，将Service微服务分别部署在了杭州机房和广州机房，这时就可以给杭州机房的Service微服务起一个集群名称(HZ) ，给广州机房的Service微服务起一个集群名称(GZ)，还可以尽量让同一个机房的微服务互相调用，以提升性能。
        最后是Instance，就是微服务的实例。
     */
}
