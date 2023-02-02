package com.example.demo.designpattern.proxy.cglib;

import com.example.demo.designpattern.proxy.jdk.PlayerCustomHandler;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class PlayerMethodInterceptor implements MethodInterceptor {

    private PlayerCustomHandler playerCustomHandler;

    public PlayerMethodInterceptor(PlayerCustomHandler playerCustomHandler) {
        this.playerCustomHandler = playerCustomHandler;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        playerCustomHandler.before();
        Object result = proxy.invokeSuper(obj, args);
        playerCustomHandler.after();
        return result;
    }
}
