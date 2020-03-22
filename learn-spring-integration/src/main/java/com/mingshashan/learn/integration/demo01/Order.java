package com.mingshashan.learn.integration.demo01;

import java.io.Serializable;
import java.util.Collection;

/**
 * Order
 *
 * @author jasonxu
 */
public class Order implements Serializable {

    private static final long serialVersionUID = -2355166833306244694L;

    private long orderId;

    private Collection<OrderItem> orderItems;

    public Collection<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public void setOrderItems(Collection<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
