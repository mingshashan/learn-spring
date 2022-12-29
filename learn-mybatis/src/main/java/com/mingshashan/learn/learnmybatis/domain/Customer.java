package com.mingshashan.learn.learnmybatis.domain;

import lombok.Data;

import java.util.List;

/**
 * @author mingshashan
 */
@Data
public class Customer {
    private String id;
    private String name;
    private String phone;
    private List<Address> addressList;
}
