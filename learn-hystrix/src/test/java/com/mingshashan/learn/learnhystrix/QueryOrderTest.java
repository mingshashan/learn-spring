package com.mingshashan.learn.learnhystrix;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * QueryOrderTest
 *
 * @author jasonxu
 */
public class QueryOrderTest {

    private final static Logger logger = LoggerFactory.getLogger(QueryOrderTest.class);

    @Test
    public void testQueryByOrderIdCommand() {

        OrderServiceProvider orderServiceProvider = new OrderServiceProvider();

        for (int i = 0; i < 1000; i++) {
            Integer r = new QueryOrderIdCommand(orderServiceProvider).execute();
            logger.info("result:{}", r);
        }

    }

}
