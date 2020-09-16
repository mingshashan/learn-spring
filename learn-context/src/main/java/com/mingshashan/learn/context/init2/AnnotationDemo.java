package com.mingshashan.learn.context.init2;

import com.mingshashan.learn.context.pojo.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * AnnotationDemo
 *
 * @author jasonxu
 */
public class AnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationConfiguration.class);
        context.refresh();

        User user1 = context.getBean(User.class);
        System.out.println(user1);
        System.out.println("user1" + user1.hashCode());
        User user2 = context.getBean(User.class);
        System.out.println(user2);
        System.out.println("user2" + user1.hashCode());
        context.close();
    }
}
