package com.yss.springcloud.alibaba.controller;

import com.yss.springcloud.alibaba.domain.CommonResult;
import com.yss.springcloud.alibaba.domain.Order;
import com.yss.springcloud.alibaba.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: ymx
 * @date: 2022/9/15
 * @description:
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;
    /**
     * 创建订单
     */
    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功!");
    }

}
