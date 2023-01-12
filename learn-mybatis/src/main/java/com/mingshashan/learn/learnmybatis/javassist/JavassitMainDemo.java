package com.mingshashan.learn.learnmybatis.javassist;

import org.apache.ibatis.javassist.util.proxy.MethodFilter;
import org.apache.ibatis.javassist.util.proxy.MethodHandler;
import org.apache.ibatis.javassist.util.proxy.ProxyFactory;

import java.lang.reflect.Method;

/**
 * @author mingshashan
 */
public class JavassitMainDemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setSuperclass(JavassistDemo.class);

        proxyFactory.setFilter(new MethodFilter() {
            @Override
            public boolean isHandled(Method method) {
                if (method.getName().equals("operation")) {
                    return true;
                }
                return false;
            }
        });

        proxyFactory.setHandler(new MethodHandler() {
            @Override
            public Object invoke(Object self, Method thisMethod, Method proceed, Object[] objects) throws Throwable {
                System.out.println("before operation");
                Object result = proceed.invoke(self, args);
                System.out.println("after operation");
                return result;
            }
        });

        // 生成代理类，并根据代理类创建代理对象
        Class<?> clazz = proxyFactory.createClass();

        JavassistDemo javassistDemo = (JavassistDemo) clazz.newInstance();
        // 执行operation方法会被拦截，进而执行代理逻辑
        javassistDemo.operation();

        System.out.println(javassistDemo.getDemoProperty());
    }
}
