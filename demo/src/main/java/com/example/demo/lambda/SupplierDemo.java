package com.example.demo.lambda;

import java.util.function.Supplier;

/**
 * @author mingshashan
 */
public class SupplierDemo {

    static String getString(Supplier<String> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
        String s = getString(new Supplier<String>() {
            @Override
            public String get() {
                return "小明";
            }
        });
        System.out.println(s);

        String s1 = getString(()->"小红");
        System.out.println(s1);
    }
}
