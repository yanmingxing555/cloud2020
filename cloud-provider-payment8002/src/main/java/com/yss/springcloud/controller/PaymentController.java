package com.yss.springcloud.controller;

import com.yss.springcloud.entities.CommonResult;
import com.yss.springcloud.entities.Payment;
import com.yss.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    @GetMapping(value = "/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }
}
