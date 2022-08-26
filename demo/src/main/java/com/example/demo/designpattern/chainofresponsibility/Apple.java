package com.example.demo.designpattern.chainofresponsibility;

/**
 * @author mingshashan
 */
public class Apple {
    /**
     * 大小，单位为厘米
     */
    private int size;

    public Apple(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
