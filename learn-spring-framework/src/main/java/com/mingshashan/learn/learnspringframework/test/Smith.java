package com.mingshashan.learn.learnspringframework.test;

import java.util.Observable;
import java.util.Observer;

/**
 * Smith
 *
 * @author jasonxu
 */
public class Smith implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Smith看到新闻:" + arg);
    }
}
