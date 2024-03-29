package com.mingshashan.learn.learnmybatis.mapper;

import com.mingshashan.learn.learnmybatis.domain.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemMapper {
    // 根据id查询OrderItem对象
    OrderItem find(String id);
    // 查询指定的订单中的全部OrderItem
    List<OrderItem> findByOrderId(String orderId);
    // 保存一个OrderItem信息
    long save(@Param("orderItem")OrderItem orderItem,
              @Param("orderId") String orderId);
}