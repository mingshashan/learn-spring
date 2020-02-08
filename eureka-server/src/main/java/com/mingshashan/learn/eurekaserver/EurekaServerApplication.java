package com.mingshashan.learn.eurekaserver;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(EurekaServerApplication.class);
        springApplicationBuilder.web(WebApplicationType.SERVLET);
        springApplicationBuilder.run(args);
//        SpringApplication.run(EurekaServerApplication.class, args);
    }

}
