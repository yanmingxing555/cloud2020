package com.yss.springcloud.alibaba.service;

import com.yss.springcloud.alibaba.domain.Order;

/**
 * @author: ymx
 * @date: 2022/9/15
 * @description:
 */
public interface OrderService {
    /**
     * 创建订单
     */
    void create(Order order);
}
