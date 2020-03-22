package com.mingshashan.learn.integration.demo01;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * OnlineShop
 *
 * @author jasonxu
 */
public class OnlineShop {
    public static void main(String[] args) {

        AbstractApplicationContext ctx =
                new ClassPathXmlApplicationContext("shop.xml");

        Shop shop = ctx.getBean(Shop.class);
        final Order order = createrOrder();

        shop.placeOrder(order);

        // Close this application context, destroying all beans in its bean factory.
        ctx.close();
    }

    private static Order createrOrder() {
        Book book = new Book("Of Mice & Men", "Bluebird", new BigDecimal("100"), 1988, "John Steinbeck");
        MusicCD cd = new MusicCD("Off the Wall", "publisher", new BigDecimal("100"), 1975, "Michael Jackson");
        Software macos = new Software("Mavericks", "publisher", new BigDecimal("100"), 2014, "10.9.3");

        OrderItem bookItems = new OrderItem(book);


        OrderItem musicItems = new OrderItem(cd);


        OrderItem softwareItems = new OrderItem(macos);


        final List<OrderItem> orderItemList = new ArrayList<>();
        orderItemList.add(bookItems);
        orderItemList.add(musicItems);
        orderItemList.add(softwareItems);

        Order order = new Order();
        order.setOrderItems(orderItemList);
        order.setOrderId(System.currentTimeMillis());

        return order;
    }

//    private static Order createrOrder() {
//
//        Order order = new Order();
//        order.setOrderId(1);
////        order.setOrderItems();
//        return order;
//    }
}
