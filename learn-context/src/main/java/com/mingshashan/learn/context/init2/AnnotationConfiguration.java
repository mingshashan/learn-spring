package com.mingshashan.learn.context.init2;

import com.mingshashan.learn.context.pojo.User;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * AnnotationConfiguration
 *
 * @author jasonxu
 */
@Configuration
public class AnnotationConfiguration {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public User user() {
        return new User("2", "帅哥");
    }
}
