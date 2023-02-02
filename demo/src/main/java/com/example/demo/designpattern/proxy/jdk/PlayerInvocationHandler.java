package com.example.demo.designpattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PlayerInvocationHandler implements InvocationHandler {
    //目标对象
    private Object target;

    private PlayerCustomHandler playerCustomHandler;

    public PlayerInvocationHandler(Object target, PlayerCustomHandler playerCustomHandler) {
        this.target = target;
        this.playerCustomHandler = playerCustomHandler;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        playerCustomHandler.before();
        Object result = method.invoke(target, args);
        playerCustomHandler.after();

        return result;
    }
}
