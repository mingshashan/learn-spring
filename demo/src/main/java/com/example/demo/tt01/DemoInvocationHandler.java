package com.example.demo.tt01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author mingshashan
 */
public class DemoInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxy, args);
    }
}
