package com.mingshashan.learn.es.config;

import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * WebConfig
 * @author jasonxu
 */
@Configuration
public class WebConfig {

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(
            Jackson2ObjectMapperBuilder builder) {

        return new MappingJackson2HttpMessageConverter(
                builder.simpleDateFormat("yyyy-MM-dd HH:mm:ss")
                        .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
                                SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS)
                        .build());
    }
}
