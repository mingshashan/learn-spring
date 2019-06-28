package com.mingshashan.learn.es.vo;

import lombok.Data;

/**
 * BookRequestVO
 */
@Data
public class BookRequestVO {

    /**
     * ID
     */
    private Long id;

    /**
     * 书名
     */
    private String name;

    /**
     * 作者
     */
    private String author;

    /**
     * 分类
     */
    private String categories;

    /**
     * 价格
     */
    private Double price;
}
