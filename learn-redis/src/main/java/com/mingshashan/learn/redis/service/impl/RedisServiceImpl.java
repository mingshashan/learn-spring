package com.mingshashan.learn.redis.service.impl;

import com.mingshashan.learn.redis.service.IRedisService;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

/**
 * RedisServiceImpl
 *
 * @author xufj
 */
@Service
public class RedisServiceImpl implements IRedisService {

    /**
     * 默认10s
     */
    static final long DEFAULT_LOCK_EXPIRE_TIME = 10;
    static final String DEFAULT_LOCK_VALUE_SUFFIX = "-lock-value";

    private final RedisTemplate redisTemplate;

    public RedisServiceImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void test() {

        // 普通KV
        testKV();

    }

    @Override
    public boolean lock(String key, Long expireTime) {


        final long expire = Objects.nonNull(expireTime) ? expireTime : DEFAULT_LOCK_EXPIRE_TIME;

        redisTemplate.execute((RedisCallback) connection -> {

            String value = key + DEFAULT_LOCK_VALUE_SUFFIX;
            byte[] keyBytes = key.getBytes();
            byte[] valueBytes = value.getBytes();

            boolean acquire = connection.setNX(keyBytes, valueBytes);

            if (acquire && connection.expire(keyBytes, expire)) {
                connection.del(keyBytes);
                return false;
            }
            return acquire;
        });

        return false;
    }

    private void testKV() {

        // set int value
        for (int i = 0; i < 10; i++) {
            String k = "int:k:" + i;
            int v = i;
            redisTemplate.opsForValue().set(k, v);
        }

        // set string value
        for (int i = 0; i < 10; i++) {
            String k = "string:k:" + i;
            String v = "v" + i;
            redisTemplate.opsForValue().set(k, v);
        }


        Set<String> keys = redisTemplate.keys("int:k:*");
//        keys.stream().map(redisTemplate.opsForValue()::get)
//        .;

        keys.forEach(item -> {
            System.out.println(redisTemplate.opsForValue().get(item));
        });

//        Flux.fromIterable(keys)
//                .doOnEach(redisTemplate.opsForValue()::get)
//                .subscribe(System.out::println);

    }
}
