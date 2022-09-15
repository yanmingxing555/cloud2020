package com.yss.springcloud.controller;

import com.yss.springcloud.service.AtomicService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: ymx
 * @date: 2022/9/14
 * @description:
 */
@RestController
public class AtomicServiceController {
    @Resource
    private AtomicService service;
    @GetMapping("/query/value11")
    public String queryValue11(){
        return service.queryValue1();
    }
    @GetMapping("/query/value12")
    public String queryValue12(){
        return service.queryValue2();
    }
    @GetMapping("/lock/test11")
    public String lockTest11() throws InterruptedException {
        service = new AtomicService();
        return service.lockTest1();
    }
    @GetMapping("/lock/test12")
    public String lockTest12(){
        service = new AtomicService();
        return service.lockTest2();
    }
    @GetMapping("index11")
    public String index1(){
        return service.index1();
    }
    @GetMapping("index12")
    public String index2(){
        return service.index2();
    }
}
