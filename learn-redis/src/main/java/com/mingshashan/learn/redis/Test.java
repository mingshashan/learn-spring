package com.mingshashan.learn.redis;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

public class Test {

    public void test() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName("192.168.254.201");
        configuration.setPort(6379);
        configuration.setDatabase(0);
        LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory(configuration);

        RedisConnection connection = connectionFactory.getConnection();
//        connection.setNX()

    }
}
