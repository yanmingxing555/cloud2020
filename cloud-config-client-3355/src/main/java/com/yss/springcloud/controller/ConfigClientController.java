package com.yss.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ymx
 * @date: 2022/9/2
 * @description:
 */
@RestController
@RefreshScope //需要运维人员发送Post(必须是post请求)请求刷新3355==>curl -X POST "http://localhost:3355/actuator/refresh"
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
