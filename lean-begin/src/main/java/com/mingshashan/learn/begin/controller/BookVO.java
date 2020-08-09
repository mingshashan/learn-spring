package com.mingshashan.learn.begin.controller;

/**
 * BookVO
 *
 * @author jasonxu
 */
public class BookVO {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookVO(String name) {
        this.name = name;
    }
}
