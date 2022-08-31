package com.yss.springcloud.service;

import com.yss.springcloud.entities.CommonResult;
import com.yss.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: ymx
 * @date: 2022/8/31
 * @description:
 */
@Component
@FeignClient(value = "cloud-payment-service")  //即使此服务没有注册进Eureka，也可以使用，并且自带负载均衡
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    //OpenFeign超时控制，OpenFeign默认等待1秒钟，超过后报错
    //超时设置，故意设置超时演示出错情况
    @GetMapping("/payment/feign/timeout")
    String paymentFeignTimeOut();
}
