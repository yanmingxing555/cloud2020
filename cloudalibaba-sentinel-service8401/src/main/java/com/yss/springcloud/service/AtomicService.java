package com.yss.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: ymx
 * @date: 2022/9/14
 * @description:
 */
@Service
public class AtomicService {
    /*****AtomicInteger测试：声明非静态，同一实例，不同线程共用AtomicInteger******/
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    public String queryValue1(){
        int next = atomicInteger.getAndIncrement();
        String str = "******value11*****"+next;
        System.out.println(str);
        return str;
    }
    public String queryValue2(){
        int next = atomicInteger.getAndIncrement();
        String str = "******value12*****"+next;
        System.out.println(str);
        return str;
    }
    /*****ReentrantLock测试：声明非静态，同一实例，不同线程共用一把锁******/
    private static final Lock lock = new ReentrantLock();
    public String lockTest1() throws InterruptedException {
        lock.lock();
        System.out.println("lockTest11获取到锁");
        Thread.sleep(10000);
        lock.unlock();
        System.out.println("lockTest11释放锁");
        return "lockTest11线程名称====》"+Thread.currentThread().getName();
    }
    public String lockTest2(){
        lock.lock();
        System.out.println("lockTest12获取到锁");
        lock.unlock();
        System.out.println("lockTest12释放锁");
        return "lockTest12线程名称====》"+Thread.currentThread().getName();
    }

    private int index = 0;
    public String index1(){
        index++;
        String str = "******index1*****"+index;
        System.out.println(str);
        return str;
    }
    public String index2(){
        index++;
        String str = "******index2*****"+index;
        System.out.println(str);
        return str;
    }
}
