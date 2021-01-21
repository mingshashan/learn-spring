package com.mingshashan.learn.redis;

import org.junit.Before;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;
import sun.reflect.ConstantPool;

import java.util.concurrent.TimeUnit;

/**
 * RedisLockTest
 *
 * @author xufj
 */
public class RedisLockTest {

    private RedissonClient redisson;

    @Before
    public void config() {
        Config config = new Config();
//        config.setTransportMode(TransportMode.NIO);
//        config.useClusterServers()
                //可以用"rediss://"来启用SSL连接
//                .addNodeAddress("redis://127.0.0.1:6379");
        config.useSingleServer()
                .setAddress("redis://127.0.0.1:6379");
        redisson = Redisson.create(config);

    }

    @Test
    public void testLock1() throws InterruptedException {
        String lockName = "myLock1";
        RLock lock = redisson.getLock(lockName);

        ConstantPool constantPool = new ConstantPool();
        lock.tryLock(1000, TimeUnit.SECONDS);
//        try {
//            boolean acquire = lock.tryLock(100, 15, TimeUnit.SECONDS);
//            if (acquire) {
//                System.out.println("获得锁");
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        for (int i = 0; i < 20; i++) {
//            new Thread(() -> {
//                String threadName = Thread.currentThread().getName();
//                System.out.println("[" + threadName + "] start");
//                try {
//                    boolean acquire = lock.tryLock(100, 10, TimeUnit.SECONDS);
//                    if (acquire) {
//                        System.out.println("[" + threadName + "] get lock");
//                        lock.unlock();
//                    } else {
//                        System.out.println("[" + threadName + "] not get lock");
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }, "testLock1-thread-" + i).start();
//        }

    }

    //    @Test
    public void getLock() {
        RLock lock = redisson.getLock("myLock");

        // traditional lock method
        lock.lock();

        // or acquire lock and automatically unlock it after 10 seconds
        lock.lock(10, TimeUnit.SECONDS);

        // or wait for lock aquisition up to 100 seconds
        // and automatically unlock it after 10 seconds
        boolean res = false;
        try {
            res = lock.tryLock(100, 10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (res) {
            try {

            } finally {
                lock.unlock();
            }
        }
    }

}
