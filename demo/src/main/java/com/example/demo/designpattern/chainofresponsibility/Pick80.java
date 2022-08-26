package com.example.demo.designpattern.chainofresponsibility;

/**
 * pick 80
 *
 * @author mingshashan
 */
public class Pick80 implements Pick {
    private Pick nextPick;

    @Override
    public void setNext(Pick nextPick) {
        this.nextPick = nextPick;
    }

    @Override
    public SizeEnum pick(Apple apple) {
        if (apple.getSize() < SIZE_90 && apple.getSize() >= SIZE_80) {
            return SizeEnum.SIZE_80;
        }
        if (null != nextPick) {
            return nextPick.pick(apple);
        }
        return SizeEnum.SIZE_UNKNOWN;
    }
}
