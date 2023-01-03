package com.mingshashan.learn.learnmybatis.mapper;

import com.mingshashan.learn.learnmybatis.domain.Customer;

/**
 * @author mingshashan
 */
public interface CustomerMapper {
    /**
     * 根据用户Id查询Customer(不查询Address)
     */
    Customer find(String id);

    /**
     * 根据用户Id查询Customer(同时查询Address)
     */
    Customer findWithAddress(String id);

    /**
     * 根据orderId查询Customer
     */
    Customer findByOrderId(long orderId);

    /**
     * 持久化Customer对象
     */
    int save(Customer customer);
}
