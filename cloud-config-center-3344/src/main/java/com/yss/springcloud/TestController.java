package com.yss.springcloud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author: ymx
 * @date: 2022/9/5
 * @description:
 */
@RestController
public class TestController {

    @GetMapping("test")
    public String test(){
        return "响应信息ok  " + UUID.randomUUID();
    }
}
