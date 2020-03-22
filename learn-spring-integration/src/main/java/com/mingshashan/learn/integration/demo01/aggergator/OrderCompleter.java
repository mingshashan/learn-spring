package com.mingshashan.learn.integration.demo01.aggergator;

import com.mingshashan.learn.integration.demo01.Order;

import java.util.List;

/**
 * OrderCompleter
 *
 * @author jasonxu
 */
public class OrderCompleter {

    public Order prepareDelivery(List orderItems) {
        final Order order = new Order();
        order.setOrderItems(orderItems);
        order.setOrderId(System.currentTimeMillis());
        return order;
    }
}
