package com.mingshashan.learn.netty.nio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import sun.misc.IOUtils;

import javax.naming.spi.DirectoryManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MappedByteBufferTest {

    private final static String CONTENT = "Zero copy implemented by MappedByteBuffer";
    private final static String FILE_NAME = "F:\\02.learn\\02.code\\learn-spring\\learn-netty\\src\\test\\resources\\files\\mmap1.txt";
    private final static String CHARSET = "UTF-8";

    private static final String SOURCE_FILE = "source.txt";
    private static final String TARGET_FILE = "target.txt";

    @Before
    public void setup() {
        Path source = new File(SOURCE_FILE).toPath();
        byte[] bytes = CONTENT.getBytes(Charset.forName(CHARSET));
        try (FileChannel fromChannel = FileChannel.open(source, StandardOpenOption.READ,
                StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {
            fromChannel.write(ByteBuffer.wrap(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void transferFrom() {
        try (FileChannel fromChannel = new RandomAccessFile(new File(SOURCE_FILE), "rw").getChannel()) {
            FileChannel toChannel = new RandomAccessFile(new File(TARGET_FILE), "rw").getChannel();

            long position = 0L;
            long offset = fromChannel.size();
            toChannel.transferFrom(toChannel, position, offset);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void transferTo() {
        try (FileChannel fromChannel = new RandomAccessFile(new File(SOURCE_FILE), "rw").getChannel()) {
            FileChannel toChannel = new RandomAccessFile(new File(TARGET_FILE), "rw").getChannel();

            long position = 0L;
            long offset = fromChannel.size();
            fromChannel.transferTo(position, offset, toChannel);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    @Test
    public void test1() {
        System.out.println(System.getProperty("user.dir"));

        File file = new File("");
        System.out.println(file.getAbsolutePath());
    }

    //    @Test
    public void writeToFileByMappedByteBuffer() {

        Path path = new File(FILE_NAME).toPath();
        byte[] bytes = CONTENT.getBytes(Charset.forName(CHARSET));

        try (FileChannel channel = FileChannel.open(path, StandardOpenOption.READ
                , StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING)) {
            MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, bytes.length);
            if (null != mappedByteBuffer) {
                mappedByteBuffer.put(bytes);
                mappedByteBuffer.force();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //    @Test
    public void readFromFileByMappedByteBuffer() {
        Path path = new File(FILE_NAME).toPath();

        int length = CONTENT.getBytes(Charset.forName(CHARSET)).length;

        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ)) {
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, length);

            if (null != mappedByteBuffer) {
                byte[] bytes = new byte[length];
                mappedByteBuffer.get(bytes);
                String readContent = new String(bytes, CHARSET);
                Assert.assertTrue(readContent.equals(CONTENT));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
