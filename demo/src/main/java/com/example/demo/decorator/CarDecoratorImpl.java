package com.example.demo.decorator;

/**
 * CarDecoratorImpl
 *
 * @author xufj
 */
public class CarDecoratorImpl extends AbstractDecorator {
    private String car = "有车";
    public void addCar() {
        System.out.print(car + " ");
    }
    public CarDecoratorImpl(Man man) {
        super(man);
    }

    @Override
    public void getInfo() {
        super.getInfo();
        addCar();
    }
}
