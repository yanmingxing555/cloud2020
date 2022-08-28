package com.yss.springcloud.service;

import com.yss.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: ymx
 * @date: 2022/8/27 0027
 * @description:
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
