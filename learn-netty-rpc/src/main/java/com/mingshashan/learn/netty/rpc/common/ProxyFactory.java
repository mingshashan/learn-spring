package com.mingshashan.learn.netty.rpc.common;

import java.lang.reflect.Proxy;

/**
 * ProxyFactory
 *
 * @author xufj
 */
public class ProxyFactory {
    public static <T> T create(Class<T> interfaceClass) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, new RpcClientDynamicProxy<T>(interfaceClass));
    }
}
