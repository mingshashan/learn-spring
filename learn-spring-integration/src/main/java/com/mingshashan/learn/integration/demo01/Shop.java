package com.mingshashan.learn.integration.demo01;

import org.springframework.integration.annotation.Gateway;

/**
 * Shop
 *
 * @author jasonxu
 */
public interface Shop {

    @Gateway(requestChannel = Demo01Constants.ORDERS_CHANNEL)
    void placeOrder(Order order);

}
