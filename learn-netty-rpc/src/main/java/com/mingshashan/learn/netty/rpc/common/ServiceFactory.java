package com.mingshashan.learn.netty.rpc.common;

import com.mingshashan.learn.netty.rpc.common.demo.HelloServiceImpl;
import com.mingshashan.learn.netty.rpc.common.demo.IHelloService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ServiceFactory
 *
 * @author xufj
 */
public class ServiceFactory {

    private static Map<Class, Object> services = new ConcurrentHashMap<>();

    public static ServiceFactory INSTANCE = new ServiceFactory();

    public ServiceFactory() {
        services.put(IHelloService.class, new HelloServiceImpl());
    }

    public Object getServiceObj(Class clazz) {
        return services.get(clazz);
    }
}
