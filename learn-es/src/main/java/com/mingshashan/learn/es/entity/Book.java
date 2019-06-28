package com.mingshashan.learn.es.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * 图书
 * @author jasonxu
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Data
@Document(indexName = "learn-es", type = "book")
public class Book implements Serializable {

    /**
     * ID
     */
    @Id
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
    private Integer category;

    /**
     * 价格
     */
    private Double price;
}