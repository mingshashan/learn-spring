package com.example.demo.designpattern.chainofresponsibility;

import java.util.*;

/**
 * @author mingshashan
 */
public class AppleGrower {

    public static void main(String[] args) {
        AppleGrower appleGrower = new AppleGrower();

        List<Apple> appleList = appleGrower.getAppleList();
        Pick pick = appleGrower.getPicks();

        appleGrower.pickApples(appleList, pick);
    }

    public void pickApples(List<Apple> appleList, Pick pick) {
        Map<SizeEnum, Integer> result = new HashMap<>();
        for (Apple apple : appleList) {
            SizeEnum sizeEnum = pick.pick(apple);
            result.put(sizeEnum, result.getOrDefault(sizeEnum, 0) + 1);
        }

        result.forEach((key, value) -> {
            System.out.printf("[%s]大小的苹果有[%d]个\n", key, value);
        });
    }

    private Pick getPicks() {

        PickSmall pickSmall = new PickSmall();
        Pick70 pick70 = new Pick70();
        pick70.setNext(pickSmall);
        Pick80 pick80 = new Pick80();
        pick80.setNext(pick70);
        Pick90 pick90 = new Pick90();
        pick90.setNext(pick80);

        return pick90;
    }

    /**
     * get apple list
     *
     * @return
     */
    private List<Apple> getAppleList() {
        List<Apple> appleList = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 77; i++) {
            Apple apple = new Apple(random.nextInt(120));
            appleList.add(apple);
        }
        return appleList;
    }
}
