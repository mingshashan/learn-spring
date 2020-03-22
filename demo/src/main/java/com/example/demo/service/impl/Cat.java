package com.example.demo.service.impl;

import com.example.demo.service.IShout;

/**
 * Cat
 *
 * @author jasonxu
 */
public class Cat implements IShout {
    @Override
    public void shout() {
        System.out.println("猫叫");
    }
}
