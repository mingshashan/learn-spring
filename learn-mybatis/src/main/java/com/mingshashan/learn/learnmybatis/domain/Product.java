package com.mingshashan.learn.learnmybatis.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author mingshashan
 */
@Data
public class Product {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
