package com.yss.springcloud.dao;

import com.yss.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: ymx
 * @date: 2022/8/27
 * @description:
 */
//@Repository不用Spring的
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
