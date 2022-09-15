package com.yss.springcloud.controller;

import com.yss.springcloud.service.AtomicService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: ymx
 * @date: 2022/9/14
 * @description:
 */
@RestController
public class AtomicController {

    /*****AtomicInteger测试：声明非静态，同一实例，不同线程共用AtomicInteger******/
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    @GetMapping("/query/value1")
    public String queryValue1(){
        int next = atomicInteger.getAndIncrement();
        String str = "******value1*****"+next;
        System.out.println(str);
        return str;
    }
    @GetMapping("/query/value2")
    public String queryValue2(){
        int next = atomicInteger.getAndIncrement();
        String str = "******value2*****"+next;
        System.out.println(str);
        return str;
    }

    /*****ReentrantLock测试：声明非静态，同一实例，不同线程共用一把锁******/
    private Lock lock = new ReentrantLock();
    @GetMapping("/lock/test1")
    public String lockTest1() throws InterruptedException {
        lock.lock();
        System.out.println("lockTest1获取到锁");
        Thread.sleep(10000);
        lock.unlock();
        System.out.println("lockTest1释放锁");
        return "lockTest1线程名称====》"+Thread.currentThread().getName();
    }
    @GetMapping("/lock/test2")
    public String lockTest2(){
        lock.lock();
        System.out.println("lockTest2获取到锁");
        lock.unlock();
        System.out.println("lockTest2释放锁");
        return "lockTest2线程名称====》"+Thread.currentThread().getName();
    }
    @Resource
    private AtomicService service;
    @GetMapping("index1")
    public String index1(){
        return service.index1();
    }
    @GetMapping("index2")
    public String index2(){
        return service.index2();
    }

}
