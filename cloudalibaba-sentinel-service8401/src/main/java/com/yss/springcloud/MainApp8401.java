package com.yss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: ymx
 * @date: 2022/9/9
 * @description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MainApp8401 {
    public static void main(String[] args) {
        SpringApplication.run(MainApp8401.class,args);
    }
    /**
     进一步解释说明：

     资源名：唯一名称，默认请求路径。
     针对来源：Sentinel可以针对调用者进行限流，填写微服务名，默认default（不区分来源）。
     阈值类型/单机阈值：
         QPS(每秒钟的请求数量)︰当调用该API的QPS达到阈值的时候，进行限流。
         线程数：当调用该API的线程数达到阈值的时候，进行限流。
     是否集群：不需要集群。
     流控模式：
         直接：API达到限流条件时，直接限流。
         关联：当关联的资源达到阈值时，就限流自己。
         链路：只记录指定链路上的流量（指定资源从入口资源进来的流量，如果达到阈值，就进行限流)【API级别的针对来源】。
     流控效果：
         快速失败：直接失败，抛异常。
         Warm up：根据Code Factor（冷加载因子，默认3）的值，从阈值/codeFactor，经过预热时长，才达到设置的QPS阈值。
         排队等待：匀速排队，让请求以匀速的速度通过，阈值类型必须设置为QPS，否则无效。
     */
    /**1.Sentinel流控
     Sentinel流控-QPS直接失败
         直接 -> 快速失败（系统默认）
         配置及说明
         表示1秒钟内查询1次就是OK，若超过次数1，就直接->快速失败，报默认错误
     Sentinel流控-线程数直接失败
        线程数：当调用该API的线程数达到阈值的时候，进行限流。
     Sentinel流控-关联
     是什么？
         当自己关联的资源达到阈值时，就限流自己
         当与A关联的资源B达到阀值后，就限流A自己（B惹事，A挂了）
     设置testA
        当关联资源/testB的QPS阀值超过1时，就限流/testA的Rest访问地址，当关联资源到阈值后限制配置好的资源名。
     链路：只记录指定链路上的流量（指定资源从入口资源进来的流量，如果达到阈值，就进行限流)【API级别的针对来源】
     Sentinel流控-预热：
        Warm Up（RuleConstant.CONTROL_BEHAVIOR_WARM_UP）方式，即预热/冷启动方式。
        当系统长期处于低水位的情况下，当流量突然增加时，直接把系统拉升到高水位可能瞬间把系统压垮。
        通过"冷启动"，让通过的流量缓慢增加，在一定时间内逐渐增加到阈值上限，给冷系统一个预热的时间，
        避免冷系统被压垮
     WarmUp配置
     案例，阀值为10+预热时长设置5秒。
     系统初始化的阀值为10/ 3约等于3,即阀值刚开始为3;然后过了5秒后阀值才慢慢升高恢复到10
     Sentinel流控-排队等待
        匀速排队，让请求以均匀的速度通过，阀值类型必须设成QPS，否则无效。
     */
    /**2.Sentinel降级
     RT（平均响应时间，秒级）
         平均响应时间 超出阈值 且 在时间窗口内通过的请求>=5，两个条件同时满足后触发降级。
         窗口期过后关闭断路器。
         RT最大4900（更大的需要通过-Dcsp.sentinel.statistic.max.rt=XXXX才能生效）。
     异常比列（秒级）
        QPS >= 5且异常比例（秒级统计）超过阈值时，触发降级;时间窗口结束后，关闭降级 。
     异常数(分钟级)
        异常数(分钟统计）超过阈值时，触发降级;时间窗口结束后，关闭降级
     */
}
