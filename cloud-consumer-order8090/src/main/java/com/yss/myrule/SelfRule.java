package com.yss.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: ymx
 * @date: 2022/8/30
 * @description: 自定义负载均衡策略规则
 */
@Configuration
public class SelfRule {
    //官方文档明确给出了警告：这个自定义配置类不能放在@ComponentScan所扫描的当前包下以及子包下，
    //否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，达不到特殊化定制的目的了。
    @Bean
    public IRule mySelfRule(){
        return new RandomRule();//定义为随机策略
    }
    /**
     ribbon负载均衡策略算法有以下几种：
         1、com.netflix.loadbalancer.RoundRobinRule：轮询策略（ribbon默认采用的负载策略）
         2、com.netflix.loadbalancer.RandomRule：随机策略
         3、com.netflix.loadbalancer.RetryRule：重试策略，先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用的服务
         4、com.netflix.loadbalancer.WeightedResponseTimeRule：权重策略，对RoundRobinRule的扩展，响应速度越快的实例选择权重越大，越容易被选择
         5、com.netflix.loadbalancer.BestAvailableRule：最小连接数策略，会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
         6、com.netflix.loadbalancer.AvailabilityFilteringRule：可用性敏感策略，先过滤掉故障实例，再选择并发较小的实例
         7、com.netflix.loadbalancer.ZoneAvoidanceRule：区域敏感策略，默认规则,复合判断server所在区域的性能和server的可用性选择服务器
     */
}
