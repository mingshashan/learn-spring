package com.mingshashan.learn.mq.rocket.learn01;

import com.mingshashan.learn.mq.rocket.MQConstant;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class OrderConsumer2 {

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(MQConstant.ORDER_CONSUMER_GROUP);
        consumer.setNamesrvAddr(MQConstant.NAME_SRV_ADDR);

        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        consumer.subscribe(MQConstant.ORDER_TOPIC, MQConstant.ORDER_TAG2);

        consumer.setMessageListener(new MessageListenerOrderly() {
            AtomicLong consumeTimes = new AtomicLong(0);

            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
                context.setAutoCommit(false);

                System.out.printf(Thread.currentThread().getName() + " Receive New Messages: " + msgs + "%n");
                this.consumeTimes.incrementAndGet();
                if (this.consumeTimes.get() % 2 == 0) {
                    return ConsumeOrderlyStatus.SUCCESS;
                }
                if (this.consumeTimes.get() % 3 == 0) {
                    return ConsumeOrderlyStatus.ROLLBACK;
                }
                if (this.consumeTimes.get() % 4 == 0) {
                    return ConsumeOrderlyStatus.COMMIT;
                }
                if (this.consumeTimes.get() % 5 == 0) {
                    context.setSuspendCurrentQueueTimeMillis(3000);
                    return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
                }


                return ConsumeOrderlyStatus.SUCCESS;
            }
        });

        consumer.start();

        System.out.println("Order Consumer start.");
    }
}
