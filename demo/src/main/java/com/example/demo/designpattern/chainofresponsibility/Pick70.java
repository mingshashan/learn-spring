package com.example.demo.designpattern.chainofresponsibility;

/**
 * pick 70
 *
 * @author mingshashan
 */
public class Pick70 implements Pick {
    private Pick nextPick;

    @Override
    public void setNext(Pick nextPick) {
        this.nextPick = nextPick;
    }

    @Override
    public SizeEnum pick(Apple apple) {
        if (apple.getSize() < SIZE_80 && apple.getSize() >= SIZE_70) {
            return SizeEnum.SIZE_70;
        }
        if (null != nextPick) {
            return nextPick.pick(apple);
        }
        return SizeEnum.SIZE_UNKNOWN;
    }
}
