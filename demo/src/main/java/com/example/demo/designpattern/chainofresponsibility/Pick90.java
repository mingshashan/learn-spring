package com.example.demo.designpattern.chainofresponsibility;

/**
 * pick 80
 *
 * @author mingshashan
 */
public class Pick90 implements Pick {

    private Pick nextPick;

    @Override
    public void setNext(Pick nextPick) {
        this.nextPick = nextPick;
    }

    @Override
    public SizeEnum pick(Apple apple) {
        if (apple.getSize() >= SIZE_90) {
            return SizeEnum.SIZE_90;
        }
        if (null != nextPick) {
            return nextPick.pick(apple);
        }
        return SizeEnum.SIZE_UNKNOWN;
    }
}
