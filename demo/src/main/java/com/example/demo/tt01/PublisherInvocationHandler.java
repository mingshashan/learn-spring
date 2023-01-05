package com.example.demo.tt01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author mingshashan
 */
public class PublisherInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if ("send".equals(method.getName())) {
            return "send msg: " + args[0];
        }

        return null;
    }
}
