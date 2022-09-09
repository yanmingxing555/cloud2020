package com.yss.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ymx
 * @date: 2022/9/9
 * @description:
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        System.out.println(Thread.currentThread().getName()+"------testA");
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        System.out.println(Thread.currentThread().getName()+"------testB");
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("------testD");
        return "------testD";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info("------testE");
        int age = 10/0;
        return "------testE";
    }

}
