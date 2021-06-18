package com.mingshashan.learn.netty.learn04;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

public class ByteBufLearn04 {
    public static void main(String[] args) {
        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer(6, 10);
        printByteBuf("ByteBufAllocator.DEFAULT.buffer(6, 10)", buf);

        buf.writeBytes(new byte[]{1, 2});
        printByteBuf("buf.writeBytes(new byte[]{1, 2})", buf);


        buf.writeInt(100);
        printByteBuf("buf.writeInt(100)", buf);

        buf.writeBytes(new byte[]{3, 4, 5});
        printByteBuf("buf.writeBytes(new byte[]{3, 4, 5})", buf);

        byte[] read = new byte[buf.readableBytes()];
        buf.readBytes(read);

        printByteBuf("buf.readBytes(read)", buf);

        printByteBuf("BeforeGetAndSet", buf);
        System.out.println("getInt(2): " + buf.getInt(2));
        buf.setByte(1, 0);
        System.out.println("getByte(1): " + buf.getByte(1));
        printByteBuf("AfterGetAndSet", buf);
    }

    private static void printByteBuf(String action, ByteBuf buf) {
        System.out.println("----------------" + action + "----------------");
        System.out.println("readerIndex(): " + buf.readerIndex());
        System.out.println("writerIndex(): " + buf.writerIndex());
        System.out.println("isReadable(): " + buf.isReadable());
        System.out.println("isWritable(): " + buf.isWritable());
        System.out.println("readableBytes(): " + buf.readableBytes());
        System.out.println("writableBytes(): " + buf.writableBytes());
        System.out.println("capacity(): " + buf.capacity());
        System.out.println("maxCapacity(): " + buf.maxCapacity());


    }
}
