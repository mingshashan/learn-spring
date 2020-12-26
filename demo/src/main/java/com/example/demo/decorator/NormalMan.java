package com.example.demo.decorator;

/**
 * 普通男人实现类
 *
 * @author xufj
 */
public class NormalMan implements Man {

    private String name;

    public NormalMan(String name) {
        this.name = name;
    }

    @Override
    public void getInfo() {
        System.out.println(name + ": ");
    }
}
