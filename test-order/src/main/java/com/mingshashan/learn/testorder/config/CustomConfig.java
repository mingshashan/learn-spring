package com.mingshashan.learn.testorder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * CustomConfig
 *
 * @author jasonxu
 */
@Configuration
public class CustomConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
