package com.example.demo.lambda;

import java.util.function.Consumer;

/**
 * @author mingshashan
 */
public class ConsumerDemo {

    static void consumer(String parameter, Consumer<String> consumer) {
        consumer.accept(parameter);
    }

    public static void main(String[] args) {
        Consumer consumer = new Consumer<String>() {
            @Override
            public void accept(String o) {
                System.out.println(o);
                String reName = new StringBuilder(o).reverse().toString();
                System.out.println(reName);
            }
        };

        consumer("小明", consumer);
    }
}
