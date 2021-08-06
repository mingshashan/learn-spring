package com.example.demo.tt01;

public class T10 {

    public static void main(String[] args) {

        double base = 10;
        double total = 0;
        double rate = 1.8;
        System.out.printf("初始为：%f万\n", base);
        System.out.println("年化收益为80%");
        for (int i = 1; i <= 10; i++) {
            total = base * rate;
            base = total;
            System.out.printf("第%d年为：%f万\n", i, total);
        }
    }
}
