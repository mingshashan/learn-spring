package com.mingshashan.learn.context.init1;

import com.mingshashan.learn.context.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * InitDemo
 *
 * @author jasonxu
 */
public class InitDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("META-INF/bean-init-context.xml");

        context.refresh();
        User user = context.getBean(User.class);
        System.out.println(user);
        context.close();
    }
}
