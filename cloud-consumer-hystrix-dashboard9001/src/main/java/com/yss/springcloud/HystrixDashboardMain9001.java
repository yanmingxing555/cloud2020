package com.yss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author: ymx
 * @date: 2022/9/1
 * @description:
 */
@SpringBootApplication
@EnableHystrixDashboard //服务监控hystrixDashboard
public class HystrixDashboardMain9001 {
    //http://localhost:9001/hystrix
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class,args);
    }
    /**
     1圈
     实心圆：共有两种含义。它通过颜色的变化代表了实例的健康程度，它的健康度从绿色<黄色<橙色<红色递减。
     该实心圆除了颜色的变化之外，它的大小也会根据实例的请求流量发生变化，流量越大该实心圆就越大。所以通过该实心圆的展示，就可以在大量的实例中快速的发现故障实例和高压力实例。

     1线
     曲线：用来记录2分钟内流量的相对变化，可以通过它来观察到流量的上升和下降趋势。
     */
}
