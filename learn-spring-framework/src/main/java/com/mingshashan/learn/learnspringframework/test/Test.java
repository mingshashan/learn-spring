package com.mingshashan.learn.learnspringframework.test;

import java.util.Observer;

/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        News news = new News();
        Observer xiaoMing = new XiaoMing();
        Observer smith = new Smith();
        news.addObserver(xiaoMing);
        news.addObserver(smith);
        news.change();
        news.notifyObservers("范冰冰分手");
    }
}
