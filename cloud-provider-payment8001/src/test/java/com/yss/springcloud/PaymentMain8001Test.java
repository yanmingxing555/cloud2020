package com.yss.springcloud;

import com.yss.springcloud.entities.Payment;
import com.yss.springcloud.service.PaymentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: ymx
 * @date: 2022/8/27
 * @description: springboot测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentMain8001Test {

    @Resource
    private PaymentService paymentService;
    @Test
    public void test(){
        Payment payment = paymentService.getPaymentById(1l);
        System.out.println(payment.toString());
    }

}
