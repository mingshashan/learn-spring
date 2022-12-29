package com.mingshashan.learn.learnmybatis.domain;

import lombok.Data;

/**
 * @author mingshashan
 */
@Data
public class Address {
    private String id;
    private String street;
    private String city;
    private String country;
    private Customer customer;
}
