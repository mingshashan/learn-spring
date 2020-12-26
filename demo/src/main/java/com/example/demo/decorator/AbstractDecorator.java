package com.example.demo.decorator;

/**
 * AbstractDecorator
 * <br/>
 * 抽象装饰者类
 *
 * @author xufj
 */
public class AbstractDecorator implements Man {
    private Man man;

    public AbstractDecorator(Man man) {
        this.man = man;
    }

    @Override
    public void getInfo() {
        man.getInfo();
    }
}
