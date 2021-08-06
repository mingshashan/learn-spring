package com.mingshashan.learn.netty.nio;

import java.nio.IntBuffer;

public class IntBufferLearn01 {

    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(10);

        System.out.printf("position = [%d]\tlimit = [%d]\tcapacity = [%d]\n", intBuffer.position(), intBuffer.limit(), intBuffer.capacity());

        intBuffer.put(6);
        intBuffer.put(16);
        System.out.printf("position = [%d]\tlimit = [%d]\tcapacity = [%d]\n", intBuffer.position(), intBuffer.limit(), intBuffer.capacity());

        intBuffer.flip();
        System.out.printf("position = [%d]\tlimit = [%d]\tcapacity = [%d]\n", intBuffer.position(), intBuffer.limit(), intBuffer.capacity());
    }
}
