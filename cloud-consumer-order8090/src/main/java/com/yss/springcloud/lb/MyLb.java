package com.yss.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: ymx
 * @date: 2022/8/31
 * @description: Ribbon之手写轮询算法
 */
@Component
public class MyLb implements LoadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 返回第几次访问
     */
    public final int getAndIncrement(){
        int current;
        int next;
        while (true){
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE?0:current+1;
            System.out.println("*****第几次访问的次数：next"+next);
            if (atomicInteger.compareAndSet(current,next)){
                return next;
            }
        }
    }
    /**
     * 负载均衡算法：rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标  ，每次服务重启动后rest接口计数从1开始。
     * @param serviceInstances 服务实例列表
     * @return 计算出来的服务实例
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
/*
Ribbon默认负载轮询算法原理：

默认负载轮训算法: rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标，每次服务重启动后rest接口计数从1开始。

List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

如:

    List [0] instances = 127.0.0.1:8002
    List [1] instances = 127.0.0.1:8001

8001+ 8002组合成为集群，它们共计2台机器，集群总数为2，按照轮询算法原理：

    当总请求数为1时:1%2=1对应下标位置为1，则获得服务地址为127.0.0.1:8001
    当总请求数位2时:2%2=О对应下标位置为0，则获得服务地址为127.0.0.1:8002
    当总请求数位3时:3%2=1对应下标位置为1，则获得服务地址为127.0.0.1:8001
    当总请求数位4时:4%2=О对应下标位置为0，则获得服务地址为127.0.0.1:8002
    如此类推…
 */
