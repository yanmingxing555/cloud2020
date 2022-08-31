package com.yss.springcloud.controller;

import com.yss.springcloud.entities.CommonResult;
import com.yss.springcloud.entities.Payment;
import com.yss.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: ymx
 * @date: 2022/8/29
 * @version: 1.0.0.0
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value(value = "${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);
        if (result > 0){
            return new CommonResult(200,"插入数据库成功，serverPort: " + serverPort,result);
        }else{
            return new CommonResult(444,"插入数据库失败",null);
        }
    }
    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        log.info("查询请求");
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null){
            return new CommonResult(200,"查询成功！，serverPort: " + serverPort,payment);
        }else{
            return new CommonResult(444,"没有对应的数据，ID="+id,null);
        }
    }

    @GetMapping("/discovery")
    public Object discovery(){
        final List<String> services = discoveryClient.getServices();
        services.forEach(element-> System.out.println("**********服务列表******"+element));
        final List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(instance-> System.out.println("*********CLOUD-PAYMENT-SERVICE实例列表信息********"+instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri()));
        return discoveryClient;
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }

    @GetMapping("/feign/timeout")
    public String paymentFeignTimeOut(){
        System.out.println("*****paymentFeignTimeOut from port: "+serverPort);
        //暂停几秒钟
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
