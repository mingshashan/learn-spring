package com.example.demo.service.impl;

import com.example.demo.service.IShout;

/**
 * Dog
 *
 * @author jasonxu
 */
public class Dog implements IShout {
    @Override
    public void shout() {
        System.out.println("狗叫");
    }
}
