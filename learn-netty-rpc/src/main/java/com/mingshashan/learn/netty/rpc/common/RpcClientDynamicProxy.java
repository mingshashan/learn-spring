package com.mingshashan.learn.netty.rpc.common;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * RpcClientDynamicProxy
 *
 * @author xufj
 */
public class RpcClientDynamicProxy<T> implements InvocationHandler {

    private Class<T> clazz;
    private NettyClient nettyClient;

    public RpcClientDynamicProxy(Class<T> clazz) {
        this.clazz = clazz;
        nettyClient = new NettyClient("127.0.0.1", 8888);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        RpcRequest request = new RpcRequest();
        String requestId = UUID.randomUUID().toString();
        String className = method.getDeclaringClass().getName();
        String methodName = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();

        request.setRequestId(requestId);
        request.setClassName(className);
        request.setMethodName(methodName);
        request.setParameterTypes(parameterTypes);
        request.setParameters(args);


        nettyClient.connect();
        RpcResponse response = nettyClient.send(request);

        return response.getResult();
    }
}
