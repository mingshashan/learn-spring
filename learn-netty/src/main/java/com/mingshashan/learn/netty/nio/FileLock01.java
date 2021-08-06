package com.mingshashan.learn.netty.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

public class FileLock01 {
    public static void main(String[] args) {
        final File file = new File("E:" + File.separator + "aaa.txt");
        FileLock01 fileLock01 = new FileLock01();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                fileLock01.lockFile(file);
            }, "thread-" + i).start();
        }
    }

    private void lockFile(File file) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file, true);
             FileChannel fileChannel = fileOutputStream.getChannel()) {

            FileLock fileLock = fileChannel.tryLock();

            if (null != fileLock) {
                System.out.println(Thread.currentThread().getName() + "---->" + file.getName() + "文件锁定");
                Thread.sleep(5000);
                fileLock.release();
                System.out.println(Thread.currentThread().getName() + "---->" + file.getName() + "文件解除锁定");
            } else {
                System.out.println(Thread.currentThread().getName() + "---->" + "未获得文件锁");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (OverlappingFileLockException e) {
            System.out.println("已经被其他线程锁定");
        }
    }
}