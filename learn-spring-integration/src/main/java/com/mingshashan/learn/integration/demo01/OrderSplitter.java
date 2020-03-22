package com.mingshashan.learn.integration.demo01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.splitter.AbstractMessageSplitter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

/**
 * OrderSplitterListener
 *
 * @author jasonxu
 */
public class OrderSplitter extends AbstractMessageSplitter {

    private static final Logger logger = LoggerFactory.getLogger(OrderSplitter.class);

    /**
     * Subclasses must override this method to split the received Message. The return value may be a Collection or
     * Array. The individual elements may be Messages, but it is not necessary. If the elements are not Messages, each
     * will be provided as the payload of a Message. It is also acceptable to return a single Object or Message. In that
     * case, a single reply Message will be produced.
     *
     * @param message The message.
     * @return The result of splitting the message.
     */
    @Override
    protected Object splitMessage(Message<?> message) {
        MessageHeaders messageHeaders = message.getHeaders();

        Order order = (Order) message.getPayload();

        logger.error("*** [OrderSplitter] splitting Order into it's constituent OrderItems : number of OrderItems: " + ((Order) message.getPayload()).getOrderItems().size() + " ****");


        return order.getOrderItems();
    }
}
