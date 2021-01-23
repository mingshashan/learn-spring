package com.mingshashan.learn.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class LearnRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnRedisApplication.class, args);

    }

}
