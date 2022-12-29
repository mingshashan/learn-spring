package com.mingshashan.learn.learnmybatis.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author mingshashan
 */
@Data
public class Order {
    private String id;
    private Customer customer;
    private Address deliveryAddress;
    private List<OrderItem> orderItemList;
    private LocalDateTime createTime;
    private BigDecimal totalPrice;
}
