package com.example.demo.designpattern.chainofresponsibility;

/**
 * small pick
 */
public class PickSmall implements Pick {

    private Pick nextPick;

    @Override
    public void setNext(Pick nextPick) {
        this.nextPick = nextPick;
    }

    @Override
    public SizeEnum pick(Apple apple) {
        if (apple.getSize() < SIZE_70) {
            return SizeEnum.SIZE_SMALL;
        }
        if (null != nextPick) {
            return nextPick.pick(apple);
        }
        return SizeEnum.SIZE_UNKNOWN;
    }
}
