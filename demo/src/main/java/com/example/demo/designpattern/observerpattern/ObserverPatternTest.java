package com.example.demo.designpattern.observerpattern;

/**
 * The Observer Pattern test
 *
 * @author
 */
public class ObserverPatternTest {

    public static void main(String[] args) {
        InformationWebsite website = new InformationWebsite();

        Observer jessica = new Jessica();
        Observer parker = new Parker();
        Observer vicente = new Vicente();

        website.register(jessica);
        website.register(parker);
        website.register(vicente);

        Message message = new Message("Tomorrow is sunny.");
        website.changeMessage(message);

        System.out.println("------update observers-----");
        website.unregister(jessica);
        Message newMessage = new Message("It will rain the day after tomorrow");
        website.changeMessage(newMessage);

    }
}
