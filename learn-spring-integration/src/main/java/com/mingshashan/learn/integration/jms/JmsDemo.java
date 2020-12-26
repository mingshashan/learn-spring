package com.mingshashan.learn.integration.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;
import java.util.concurrent.TimeUnit;

/**
 * JmsDemo
 *
 * @author xufj
 */
public class JmsDemo {

    private static String BROKER_URL = "tcp://localhost:61616";

    public static void main(String[] args) throws JMSException, InterruptedException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        Queue queue = new ActiveMQQueue("hello-queue");
//        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Session session = connection.createSession(true, Session.CLIENT_ACKNOWLEDGE);

        MessageProducer messageProducer = session.createProducer(queue);
        ActiveMQTextMessage message = new ActiveMQTextMessage();

        for (int i = 0; i < 100; i++) {
            message.setText("n" + i);
            messageProducer.send(message, new CompletionListener() {
                @Override
                public void onCompletion(Message message) {
                    try {
                        session.commit();
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onException(Message message, Exception exception) {
                    try {
                        session.rollback();
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
            TimeUnit.SECONDS.sleep(2);
        }


        messageProducer.close();
        session.close();
        connection.close();

    }
}
