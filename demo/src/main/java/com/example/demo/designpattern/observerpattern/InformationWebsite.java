package com.example.demo.designpattern.observerpattern;

import java.util.LinkedList;
import java.util.List;

/**
 * the subject
 *
 * @author
 */
public class InformationWebsite {

    /**
     * the message
     */
    private Message message;

    private List<Observer> observerList = new LinkedList<>();

    public void register(Observer observer) {
        if (null == observer) {
            System.out.println("observer should not be null");
        }
        observerList.add(observer);
    }

    public void unregister(Observer observer) {
        if (null == observer) {
            System.out.println("observer should not be null");
        }
        observerList.remove(observer);
    }

    public void notifyObserverList() {
        for (Observer o : observerList) {
            o.update(message);
        }
    }

    public void changeMessage(Message message) {
        this.message = message;
        notifyObserverList();
    }
}
