package com.mingshashan.learn.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LearnSpringIntegrationApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(LearnSpringIntegrationApplication.class, args);
        LearnSpringIntegrationApplication application = context.getBean(LearnSpringIntegrationApplication.class);
        System.out.println(application);
    }

}
