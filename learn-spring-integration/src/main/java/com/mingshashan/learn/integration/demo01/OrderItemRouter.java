package com.mingshashan.learn.integration.demo01;

/**
 * OrderItemRouter
 *
 * @author jasonxu
 */
public class OrderItemRouter {

    public String routeOrder(OrderItem orderItem) {

        String channel = "";

        if (isBook(orderItem)) {
            channel = Demo01Constants.CHANNEL_BOOK;
        }
        if (isMusic(orderItem)) {
            channel = Demo01Constants.CHANNEL_MUSIC;
        }
        if (isSoftware(orderItem)) {
            channel = Demo01Constants.CHANNEL_SOFTWARE;
        }

        return channel;
    }


    /**
     * is software
     *
     * @param orderItem
     * @return
     */
    private boolean isSoftware(OrderItem orderItem) {
        if (orderItem.getItem().getClass().isAssignableFrom(Software.class)) {
            return true;
        }

        return false;
    }

    /**
     * is music
     *
     * @param orderItem
     * @return
     */
    private boolean isMusic(OrderItem orderItem) {
        if (orderItem.getItem().getClass().isAssignableFrom(MusicCD.class)) {
            return true;
        }
        return false;
    }

    /**
     * is book
     *
     * @param orderItem
     * @return
     */
    private boolean isBook(OrderItem orderItem) {
        if (orderItem.getItem().getClass().isAssignableFrom(Book.class)) {
            return true;
        }

        return false;
    }
}
