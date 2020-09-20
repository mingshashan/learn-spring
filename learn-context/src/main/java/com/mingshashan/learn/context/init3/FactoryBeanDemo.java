package com.mingshashan.learn.context.init3;

import com.mingshashan.learn.context.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/bean-init-context.xml");

        User factoryBeanUser = context.getBean("userFactoryBean", User.class);

        System.out.println(factoryBeanUser);
    }
}
