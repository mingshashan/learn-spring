package com.example.demo.decorator;

/**
 * HouseDecoratorImpl
 *
 * @author xufj
 */
public class HouseDecoratorImpl extends AbstractDecorator {

    private String house = "有房";

    public HouseDecoratorImpl(Man man) {
        super(man);
    }

    public void addHouse() {
        System.out.print(house + " ");
    }

    @Override
    public void getInfo() {
        super.getInfo();
        addHouse();
    }

}
