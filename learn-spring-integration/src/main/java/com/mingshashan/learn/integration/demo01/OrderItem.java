package com.mingshashan.learn.integration.demo01;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * OrderItem
 *
 * @author jasonxu
 */
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 5460566514445292572L;

    private int count;

    private BigDecimal discountedPrice;

    private Item item;

    public OrderItem(Item item) {
        this.item = item;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(BigDecimal discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public BigDecimal getTotalPrice() {
        return item.getPrice().multiply(new BigDecimal(count));
    }

}
