package com.mingshashan.learn.begin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@EnableEurekaClient
public class LeanBeginApplication {

//    @Bean
//    public TestApplicationListener testApplicationListener() {
//        return new TestApplicationListener();
//    }

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(LeanBeginApplication.class);
//        springApplication.addListeners(new TestApplicationListener());
        ConfigurableApplicationContext context = springApplication.run(args);
        LeanBeginApplication application = context.getBean(LeanBeginApplication.class);
        System.out.println(application);
//        context.close();/**/
//        SpringApplicationBuilder builder = new SpringApplicationBuilder();
//        builder.main(LeanBeginApplication.class);
//        builder.listeners(new TestApplicationListener());
//        builder.build(args);
//        builder.run();
//        SpringApplication.run(LeanBeginApplication.class, args);
    }

}
