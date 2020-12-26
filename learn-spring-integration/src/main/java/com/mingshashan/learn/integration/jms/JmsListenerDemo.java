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
public class JmsListenerDemo {

    private static String BROKER_URL = "tcp://localhost:61616";

    public static void main(String[] args) throws JMSException, InterruptedException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        Queue queue = new ActiveMQQueue("hello-queue");
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        MessageConsumer messageConsumer = session.createConsumer(queue);
        messageConsumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                ActiveMQTextMessage aMessage = new ActiveMQTextMessage();
                try {
                    System.out.println("listener receive message : " + aMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }

            }
        });

        TimeUnit.SECONDS.sleep(100);
        messageConsumer.close();
        session.close();
        connection.close();

    }
}
