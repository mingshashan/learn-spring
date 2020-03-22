package com.mingshashan.learn.integration.demo01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * Shopkeeper
 *
 * @author jasonxu
 */
public class Shopkeeper {

    private static final Logger log = LoggerFactory.getLogger(Shopkeeper.class);

    private static final BigDecimal BOOK_DISCOUNT = new BigDecimal(0.05);

    private static final BigDecimal MUSIC_DISCOUNT = new BigDecimal(0.10);

    private static final BigDecimal SOFTWARE_DISCOUNT = new BigDecimal(0.15);

    /**
     * perform discount on books
     *
     * @param bookOrderItem OrderItem comprising of a book item
     * @return OrderItem with discount price newly calculated
     */
    public OrderItem processBook(OrderItem bookOrderItem) {
        log.debug("*** [Shopkeeper] processing book : " + bookOrderItem.getItem().getTitle() + " ****");

        final BigDecimal finalPrice
                = calculateDiscountedPrice(bookOrderItem, BOOK_DISCOUNT);
        bookOrderItem.setDiscountedPrice(finalPrice);

        return bookOrderItem;
    }

    public OrderItem processMusic(OrderItem musicOrderItem) {
        log.debug("*** [Shopkeeper] processing music : " + musicOrderItem.getItem().getTitle() + " ****");

        final BigDecimal finalPrice
                = calculateDiscountedPrice(musicOrderItem, BOOK_DISCOUNT);
        musicOrderItem.setDiscountedPrice(finalPrice);

        return musicOrderItem;
    }

    public OrderItem processSoftware(OrderItem softwareOrderItem) {
        log.debug("*** [Shopkeeper] processing software : " + softwareOrderItem.getItem().getTitle() + " ****");
        final BigDecimal finalPrice
                = calculateDiscountedPrice(softwareOrderItem, BOOK_DISCOUNT);
        softwareOrderItem.setDiscountedPrice(finalPrice);

        return softwareOrderItem;
    }

    /*
     * Computes the new discounted price for an item
     * @param orderItem the item of interest
     * @param discount The amount to be discounted.
     */
    private BigDecimal calculateDiscountedPrice(final OrderItem orderItem, final BigDecimal discount) {

        final BigDecimal discountedPrice = round(orderItem.getTotalPrice().multiply(discount));
        final BigDecimal finalPrice = round(orderItem.getTotalPrice().subtract(discountedPrice));

        log.debug("item (" + getItemType(orderItem) + ") " +
                "item price: " + orderItem.getItem().getPrice() +
                " discount: " + discountedPrice +
                " final price: " + finalPrice);

        return finalPrice;
    }

    private String getItemType(final OrderItem orderItem) {

        String type = "";

        if (orderItem.getItem() instanceof Book) {
            type = "Book: " + orderItem.getItem().getTitle();
        } else if (orderItem.getItem() instanceof MusicCD) {
            type = "MusicCD: " + orderItem.getItem().getTitle();
        } else if (orderItem.getItem() instanceof Software) {
            type = "Software: " + orderItem.getItem().getTitle();
        }

        return type;
    }

    /**
     * Round for currency values
     *
     * @param value
     * @return
     */
    private BigDecimal round(final BigDecimal value) {
        return value.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

//    private BigDecimal calculateDiscountedPrice(@NotNull OrderItem orderItem, BigDecimal discount) {
//
//        final BigDecimal onePrice = orderItem.getItem().getPrice()
//                .multiply(discount);
//
//        final BigDecimal allPrice = onePrice.multiply(BigDecimal.valueOf(orderItem.getCount()));
//
//        return allPrice;
//    }

}
