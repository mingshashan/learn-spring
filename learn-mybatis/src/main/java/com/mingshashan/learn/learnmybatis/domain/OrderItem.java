package com.mingshashan.learn.learnmybatis.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author mingshashan
 */
@Data
public class OrderItem {
    private String id;
    private Product product;
    private Integer amount;
    private BigDecimal price;
    private String orderId;
}
