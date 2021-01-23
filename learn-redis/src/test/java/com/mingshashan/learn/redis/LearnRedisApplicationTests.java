package com.mingshashan.learn.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.TestPropertySource;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@SpringBootTest()
@TestPropertySource("classpath:application.properties")
class LearnRedisApplicationTests {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSet() throws InterruptedException {
/*        redisTemplate.opsForValue().set("k1", "v1");
        redisTemplate.opsForValue().set("k2", "v2");
        redisTemplate.opsForValue().set("k3", "v3");
        redisTemplate.opsForValue().set("k4", "v4");
        redisTemplate.opsForValue().set("k5", "v5");*/

        final String k = "mLock";
        final String v = "mValue";

//        long l = 10;
//        Boolean isGetLock = redisTemplate.opsForValue().setIfAbsent(k, v, l, TimeUnit.SECONDS);
//        if (isGetLock) {
//            System.out.println(Thread.currentThread().getName() + "获得锁成功");
//        }


//        redisTemplate.opsForValue().set("k6", "v6");
//        Duration duration = Duration.ofSeconds(10);
//        redisTemplate.expire(k, duration);
//        TimeUnit.SECONDS.sleep(10);
//        for (int i = 0; i < 100; i++) {
//            new Thread(() -> {
//                Boolean isGetLock = redisTemplate.opsForValue().setIfAbsent(k, v, 100, TimeUnit.SECONDS);
//
//                if (isGetLock) {
//                    System.out.println(Thread.currentThread().getName() + "获得锁成功");
//                } else {
//                    System.out.println(Thread.currentThread().getName() + "获得锁失败");
//                }
//            }, "thread-" + i).start();
//        }

        for (int i = 0; i < 100; i++) {
            String key = "kk" +i;
            String value = "vv" + i;

            redisTemplate.opsForValue().set(key, value);
//            new Thread(new Task(key, value, redisTemplate)).start();
//            new Thread(() -> {
//                System.out.println("set " + key + ":" +value);
//                redisTemplate.opsForValue().set(key, value);
//
//                if(key.equals("kk99")) {
//                    System.out.println("haha");
//                }
//            }).start();
        }
    }


    class Task implements Runnable {

        private String k;
        private String v;
        private RedisTemplate<String, String> redisTemplate;

        public Task(String k, String v, RedisTemplate<String, String> redisTemplate) {
            this.k = k;
            this.v = v;
            this.redisTemplate = redisTemplate;
        }

        @Override
        public void run() {
            System.out.println("set " + k + ":" +v);
            this.redisTemplate.opsForValue().set(k, v);
        }
    }

}
