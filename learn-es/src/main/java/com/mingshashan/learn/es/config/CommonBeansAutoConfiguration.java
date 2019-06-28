package com.mingshashan.learn.es.config;

import com.mingshashan.learn.es.context.SpringApplicationContextHolder;
import com.mingshashan.learn.es.handler.CommonExceptionResolverHandler;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NamingConventions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author jasonxu
 */
@Slf4j
@Configuration
public class CommonBeansAutoConfiguration {

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SpringApplicationContextHolder getSpringApplicationContextHolder() {
        return new SpringApplicationContextHolder();
    }


    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public CommonExceptionResolverHandler exceptionHandleService() {
        log.info("Create bean " + CommonExceptionResolverHandler.class.getName());
        return new CommonExceptionResolverHandler();
    }


    @Bean
    public ModelMapper modelMapper() {

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setFieldMatchingEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE).setSkipNullEnabled(true).setAmbiguityIgnored(true)
                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
        return mapper;
    }

}
