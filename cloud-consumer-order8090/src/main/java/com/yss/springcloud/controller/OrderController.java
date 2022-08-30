package com.yss.springcloud.controller;

import com.yss.springcloud.entities.CommonResult;
import com.yss.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author: ymx
 * @date: 2022/8/29
 * @description:
 */
@RestController
@RequestMapping("/consumer/payment")
public class OrderController {

    //支付服务是单机版可以直接写地址
    //public static final String PaymentSrv_URL = "http://localhost:8001";
    //支付服务是集群，则需要通过restTemplate的客户端负载均衡的功能，直接访问被调用服务的名称，而不必在关心ip和端口
    //Ribbon和Eureka整合后Consumer可以直接调用服务而不用再关心地址和端口号，且该服务还有负载功能了
    public static final String PaymentSrv_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/create") //客户端用浏览器是get请求，但是底层实质发送post调用服务端8001
    public CommonResult create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PaymentSrv_URL + "/payment/create",payment,CommonResult.class);
    }
    @GetMapping("/get/{id}")
    public CommonResult getPayment(@PathVariable Long id) {
        return restTemplate.getForObject(PaymentSrv_URL + "/payment/get/"+id, CommonResult.class, id);
    }

}
