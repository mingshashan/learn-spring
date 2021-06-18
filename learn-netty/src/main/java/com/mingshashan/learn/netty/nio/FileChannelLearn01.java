package com.mingshashan.learn.netty.nio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;

public class FileChannelLearn01 {

    public static void main(String[] args) {
        String[] info = new String[]{"今天", "下", "雨", "挺大的"};

        FileAttribute attribute = new FileAttribute() {
            @Override
            public String name() {
                return "type";
            }

            @Override
            public Object value() {
                return "TTT";
            }
        };

        FileOutputStream outputStream = null;

        FileChannel fileChannel = null;
        Path path = Paths.get("F:\\02.learn\\0.temp\\test01.txt");
        try {
//            Path filePath = Files.createFile(path, attribute);
            if (!path.toFile().exists()) {
                Files.createFile(path);
            }
            Path filePath = path;

            outputStream = new FileOutputStream(filePath.toFile());

            fileChannel = outputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(2048);

            for (int i = 0; i < info.length; i++) {
                byteBuffer.put(info[i].getBytes(StandardCharsets.UTF_8));
            }

            // 可写切换成只读
            byteBuffer.flip();
            fileChannel.write(byteBuffer);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != fileChannel) {
                try {
                    fileChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
