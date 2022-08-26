package com.example.demo.designpattern.chainofresponsibility;

/**
 * @author mingshashan
 */
public interface Pick {

    /**
     * size 70
     */
    int SIZE_70 = 70;

    /**
     * size 80
     */
    int SIZE_80 = 80;

    /**
     * size 90
     */
    int SIZE_90 = 90;

    /**
     * 设置下一个挑选处理对象
     *
     * @param nextPick
     */
    void setNext(Pick nextPick);

    /**
     * 挑选
     *
     * @param apple
     * @return
     */
    SizeEnum pick(Apple apple);
}
