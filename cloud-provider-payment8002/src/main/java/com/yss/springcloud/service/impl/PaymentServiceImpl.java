package com.yss.springcloud.service.impl;

import com.yss.springcloud.dao.PaymentDao;
import com.yss.springcloud.entities.Payment;
import com.yss.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: ymx
 * @date: 2022/8/27 0027
 * @description:
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
