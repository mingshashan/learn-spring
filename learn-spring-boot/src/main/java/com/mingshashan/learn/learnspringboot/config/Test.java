package com.mingshashan.learn.learnspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Test
 *
 * @author jasonxu
 */
@Configuration
public class Test {

    @Bean
    public String haha() {
        return "haha";
    }
}
