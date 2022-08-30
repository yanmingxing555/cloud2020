package com.yss.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: ymx
 * @date: 2022/8/30
 * @description:
 */
@Configuration
public class MySelfRule {
    //官方文档明确给出了警告：这个自定义配置类不能放在@ComponentScan所扫描的当前包下以及子包下，
    // 否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，达不到特殊化定制的目的了。
    @Bean
    public IRule mySelfRule(){
        return new RandomRule();//定义为随机
    }
}
