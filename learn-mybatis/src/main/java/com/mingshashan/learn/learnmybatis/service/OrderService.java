package com.mingshashan.learn.learnmybatis.service;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.mingshashan.learn.learnmybatis.domain.Address;
import com.mingshashan.learn.learnmybatis.domain.Order;
import com.mingshashan.learn.learnmybatis.domain.OrderItem;
import com.mingshashan.learn.learnmybatis.mapper.AddressMapper;
import com.mingshashan.learn.learnmybatis.mapper.OrderItemMapper;
import com.mingshashan.learn.learnmybatis.mapper.OrderMapper;
import com.mingshashan.learn.learnmybatis.util.DaoUtils;

import java.math.BigDecimal;
import java.util.List;

public class OrderService {
    // 创建订单
    public String createOrder(Order order) {
        Preconditions.checkArgument(order != null, "order is null");
        Preconditions.checkArgument(order.getOrderItemList() != null
                        && order.getOrderItemList().size() > 0,
                "orderItems is empty");
        return DaoUtils.execute(sqlSession -> {
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            OrderItemMapper orderItemMapper = sqlSession.getMapper(OrderItemMapper.class);
            // 调用OrderMapper.save()方法完成订单的持久化
            long affected = orderMapper.save(order);
            if (affected <= 0) {
                throw new RuntimeException("Save Order fail...");
            }
            String orderId = order.getId();
            for (OrderItem orderItem : order.getOrderItemList()) {
                // 通过OrderItemMapper完成OrderItem的持久化
                orderItemMapper.save(orderItem, orderId);
            }
            return orderId;
        });
    }

    // 根据订单id查询订单的全部信息
    public Order find(String orderId) {
        // 检查orderId参数是否合法
        Preconditions.checkArgument(!Strings.isNullOrEmpty(orderId), "orderId is empty");

        return DaoUtils.execute(sqlSession -> {
            // 查询该订单关联的全部OrderItem
            OrderItemMapper orderItemMapper = sqlSession.getMapper(OrderItemMapper.class);
            List<OrderItem> orderItems = orderItemMapper.findByOrderId(orderId);
            // 查询订单本身的信息
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            Order order = orderMapper.find(orderId);
            order.setOrderItemList(orderItems);
            // 计算订单总额
            order.setTotalPrice(calculateTotalPrice(order));
            // 查询订单关联的Address
            AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
            Address address = addressMapper.find(order.getDeliveryAddress().getId());
            order.setDeliveryAddress(address);
            return order;
        });
    }

    private BigDecimal calculateTotalPrice(Order order) {
        List<OrderItem> orderItems = order.getOrderItemList();
        BigDecimal totalPrice = new BigDecimal(0);
        for (OrderItem orderItem : orderItems) {
            BigDecimal itemPrice = orderItem.getProduct().getPrice()
                    .multiply(new BigDecimal(orderItem.getAmount()));
            orderItem.setPrice(itemPrice);
            totalPrice.add(itemPrice);
        }
        return totalPrice;
    }
}