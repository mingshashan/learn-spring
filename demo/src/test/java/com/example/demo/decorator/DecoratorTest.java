package com.example.demo.decorator;

import org.junit.Test;

/**
 * DecoratorTest
 *
 * @author xufj
 */
public class DecoratorTest {

    @Test
    public void test() {
        Man man = new NormalMan("张三");
        Man man1 = new CarDecoratorImpl(man);
        Man man2 = new HouseDecoratorImpl(man1);
        Man man3 = new DepositDecoratorImpl(man2);
        System.out.println("层层装饰:");
        man3.getInfo();
        System.out.println();

        System.out.println("重复装饰（有两个'有存款'）:");
        Man man4 = new DepositDecoratorImpl(man3);
        man4.getInfo();
        System.out.println();

        System.out.println("直接得到修饰结果:");
        Man man6 = new HouseDecoratorImpl(new DepositDecoratorImpl(new NormalMan("李四")));
        man6.getInfo();
        System.out.println();
    }
}
