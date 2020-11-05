package com.example.demo.reactor.demo01;

/**
 * DivideIntegerSupplier
 *
 * @author jasonxu
 */
public class DivideIntegerSupplier {
    private Integer i;
    private Integer j;

    public DivideIntegerSupplier(Integer i, Integer j) {
        this.i = i;
        this.j = j;
    }

    public Integer get() {
        return i / j;
    }
}
