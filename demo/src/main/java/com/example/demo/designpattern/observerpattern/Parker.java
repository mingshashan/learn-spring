package com.example.demo.designpattern.observerpattern;

/**
 * the concrete observer
 *
 * @author
 */
public class Parker implements Observer {
    @Override
    public void update(Message message) {
        if (null == message) {
            return;
        }
        System.out.printf("Parker receive message: [%s]\n", message.getData());
    }
}
