package com.example.demo.tt01;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author mingshashan
 */
public class PublisherProxyDemo {
    public static void main(String[] args) throws Throwable {
        PublisherInvocationHandler publisherInvocationHandler = new PublisherInvocationHandler();
        Object proxy =
                Proxy.newProxyInstance(PublisherProxyDemo.class.getClassLoader(),
                        new Class[]{Publisher.class}, publisherInvocationHandler);

        Method method = Publisher.class.getMethod("send", String.class);

        Object result = publisherInvocationHandler.invoke(proxy, method, new Object[]{"json"});

        System.out.println(result);
    }
}
