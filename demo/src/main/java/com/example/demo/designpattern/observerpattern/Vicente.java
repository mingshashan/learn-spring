package com.example.demo.designpattern.observerpattern;

/**
 * the concrete observer
 *
 * @author
 */
public class Vicente implements Observer {
    @Override
    public void update(Message message) {
        if (null == message) {
            return;
        }
        System.out.printf("Vicente receive message: [%s]\n", message.getData());
    }
}
