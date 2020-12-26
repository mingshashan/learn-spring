package com.example.demo.decorator;

/**
 * DepositDecoratorImpl
 *
 * @author xufj
 */
public class DepositDecoratorImpl extends AbstractDecorator{

    private String deposit = "有存款";

    public void addDeposit() {
        System.out.print(deposit + " ");
    }

    public DepositDecoratorImpl(Man man) {
        super(man);
    }

    @Override
    public void getInfo() {
        super.getInfo();
        addDeposit();
    }
}
