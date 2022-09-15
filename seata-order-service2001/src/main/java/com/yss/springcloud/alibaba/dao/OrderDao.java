package com.yss.springcloud.alibaba.dao;

import com.yss.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: ymx
 * @date: 2022/9/15
 * @description:
 */
@Mapper
public interface OrderDao {
    /**
     * 创建订单
     */
    void create(Order order);
    /**
     * 修改订单金额
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
