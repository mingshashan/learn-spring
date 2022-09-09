package com.example.demo.designpattern.observerpattern;

/**
 * observer interface
 *
 * @author
 */
public interface Observer {

    /**
     * update
     *
     * @param message the message from subject( {@link com.example.demo.designpattern.observerpattern.InformationWebsite})
     */
    void update(Message message);
}
