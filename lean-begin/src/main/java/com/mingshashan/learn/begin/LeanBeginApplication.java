package com.mingshashan.learn.begin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LeanBeginApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeanBeginApplication.class, args);
    }

}
