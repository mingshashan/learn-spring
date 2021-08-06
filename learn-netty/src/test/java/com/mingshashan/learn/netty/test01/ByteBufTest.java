package com.mingshashan.learn.netty.test01;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.junit.jupiter.api.Test;

/**
 * ByteBufTest
 *
 * @author xufj
 */
public class ByteBufTest {

    @Test
    public void test() {
        // 初始容量6，最大容量10
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(6, 10);
        printByteBufInfo("ByteBufAllocator.DEFAULT.buff(6,10)", buffer);

        // 写入两个字节
        buffer.writeBytes(new byte[]{1, 2});
        printByteBufInfo("write 2 bytes", buffer);

        // 写入一个int型数据，JAVA int占4个字节
        buffer.writeInt(100);
        printByteBufInfo("write Int 100", buffer);

        // 再写入三个字节
        buffer.writeBytes(new byte[]{3, 4, 5});
        printByteBufInfo("write 3 Bytes", buffer);

        // 再写入一个Long，试一下，因为最大容量是10，已经写了9个，所以应该是不可写的情况
        if (buffer.isWritable(Long.BYTES)) {
            buffer.writeLong(1000L);
            printByteBufInfo("Write Long 1000L", buffer);
        }

        byte[] read = new byte[buffer.readableBytes()];
        buffer.readBytes(read);
        printByteBufInfo("readBytes(" + buffer.readableBytes() + ")", buffer);
        printByteBufInfo("BeforeGetAndSet", buffer);
        System.out.println("getInt(2)：" + buffer.getInt(2));
        buffer.setByte(1, 110);
        System.out.println("getByte(1)：" + buffer.getByte(1));
        printByteBufInfo("AfterGetAndSet", buffer);

    }

    private void printByteBufInfo(String step, ByteBuf buffer) {
        System.out.println("-------" + step + "------");
        System.out.println("readerIndex()： " + buffer.readerIndex());
        System.out.println("writerIndex()： " + buffer.writerIndex());
        System.out.println("isReadable()： " + buffer.isReadable());
        System.out.println("isWritable()： " + buffer.isWritable());
        System.out.println("readableBytes()： " + buffer.readableBytes());
        System.out.println("writableBytes()： " + buffer.writableBytes());
        System.out.println("maxWritableBytes()： " + buffer.maxWritableBytes());
        System.out.println("capacity()： " + buffer.capacity());
        System.out.println("maxCapacity()： " + buffer.maxCapacity());
    }
}
