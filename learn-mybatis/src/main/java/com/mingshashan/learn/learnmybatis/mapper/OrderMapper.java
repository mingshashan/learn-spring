package com.mingshashan.learn.learnmybatis.mapper;

import com.mingshashan.learn.learnmybatis.domain.Order;

import java.util.List;

public interface OrderMapper {
    // 根据订单Id查询
    Order find(String id);

    // 查询一个用户一段时间段内的订单列表
    List<Order> findByCustomerId(String customerId, long startTime, long endTime);

    // 保存一个订单
    long save(Order order);
}