package com.mingshashan.learn.netty.nio;

import java.nio.Buffer;
import java.nio.IntBuffer;

public class BufferLearn01 {

    public static void main(String[] args) {
        IntBuffer buf = IntBuffer.allocate(10);
        printByteBuff(buf);

        buf.put(6);
        buf.put(16);
        printByteBuff(buf);

        buf.flip();
        printByteBuff(buf);
    }

    private static void printByteBuff(Buffer buffer) {

//        System.out.printf("Buffer info [mark = %d, position = %d, limit = %d, capacity = %d]\n",
//                buffer.markValue(), buffer.position(), buffer.limit(), buffer.capacity());

        System.out.printf("Buffer info [position = %d, limit = %d, capacity = %d]\n",
                buffer.position(), buffer.limit(), buffer.capacity());

    }
}
