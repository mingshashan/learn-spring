package com.mingshashan.learn.redis;

import com.mingshashan.learn.redis.service.IRedisService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LearnRedisApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LearnRedisApplication.class, args);

		IRedisService redisService = context.getBean(IRedisService.class);
		redisService.test();

		context.close();
	}

}
