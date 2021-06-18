package com.mingshashan.learn.netty.learn04;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.PooledByteBufAllocator;

public class ByteBufLearn0402 {

    public static void main(String[] args) {
        ByteBufAllocator allocator = PooledByteBufAllocator.DEFAULT;

        // tiny规格内存分配 会变成大于等于16整数倍的数，250会规格化（向上取整）为256
        ByteBuf byteBuf = allocator.directBuffer(250);

        // 读写ByteBuf
        byteBuf.writeInt(123);

        System.out.println(byteBuf.readInt());

        // 释放内存
        byteBuf.release();


    }
}
