package com.example.demo.designpattern.proxy.javassist;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

import java.lang.reflect.Method;

public class JavassitClient {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setSuperclass(XiaoMing.class);

        Class<ProxyObject> proxyClass = proxyFactory.createClass();

        Player player = (Player) proxyClass.newInstance();

        ((ProxyObject) player).setHandler(new MethodHandler() {
            XiaoMing test = new XiaoMing();

            public Object invoke(Object self, Method thisMethod,
                                 Method proceed, Object[] args) throws Throwable {
                System.out.println("代玩开始");
                Object result = thisMethod.invoke(test, args);
                System.out.println("代玩结束");
                return result;
            }
        });
        player.playGame();
    }
}
