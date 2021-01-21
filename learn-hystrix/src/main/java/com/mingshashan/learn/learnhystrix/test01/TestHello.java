package com.mingshashan.learn.learnhystrix.test01;

/**
 * TestHello
 *
 * @author xufj
 */
public class TestHello {

    public static void main(String[] args) {
        HelloCommand helloCommand = new HelloCommand();
        String result = helloCommand.execute();
        System.out.println(result);
    }
}
