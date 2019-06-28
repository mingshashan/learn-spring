package com.mingshashan.learn.es.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * AppContextHolder. Server启动时，需要注册
 *
 * @author jasonxu
 */
public class SpringApplicationContextHolder implements ApplicationContextAware {

    private static ApplicationContext appCtx = null;

    public static ApplicationContext getApplicationContext() {
        return appCtx;
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        SpringApplicationContextHolder.appCtx = ctx;
        String applicationName = ctx.getApplicationName();
        if (applicationName.contains("_")) {
            throw new IllegalStateException("spring.application.name is not allowed to include underlines :" + applicationName);
        }
    }

    public ApplicationContext getAppContext() {
        return appCtx;
    }

}
