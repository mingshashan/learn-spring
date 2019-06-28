package com.mingshashan.learn.learnspringframework.test;

import java.util.Observable;

/**
 * News
 *
 * @author jasonxu
 */
public class News extends Observable {

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void change() {
        super.setChanged();
    }

}
