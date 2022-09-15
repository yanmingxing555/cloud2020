package com.yss.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: ymx
 * @date: 2022/9/15
 * @description:
 */
@Configuration
@MapperScan({"com.yss.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
