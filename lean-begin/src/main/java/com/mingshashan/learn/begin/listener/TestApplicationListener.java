package com.mingshashan.learn.begin.listener;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;

public class TestApplicationListener
        implements ApplicationListener<ApplicationEnvironmentPreparedEvent>, Ordered {
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {


        System.out.println("------------------");
        System.out.println("--------TEST------");
        System.out.println(event.getEnvironment().toString());
        System.out.println("------------------");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

