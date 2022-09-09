package com.example.demo.designpattern.observerpattern;

/**
 * the message(state of Observer Pattern)
 *
 * @author
 */
public class Message {
    private String data;

    public Message(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
