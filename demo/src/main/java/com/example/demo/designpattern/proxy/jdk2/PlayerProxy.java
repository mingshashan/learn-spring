package com.example.demo.designpattern.proxy.jdk2;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.*;

public class PlayerProxy implements InvocationHandler {

    private static final int ALLOWED_MODES = MethodHandles.Lookup.PRIVATE | MethodHandles.Lookup.PROTECTED
            | MethodHandles.Lookup.PACKAGE | MethodHandles.Lookup.PUBLIC;

    private Object target;
    private static final Constructor<MethodHandles.Lookup> lookupConstructor;

    static {
        Constructor<MethodHandles.Lookup> lookup = null;

        // JDK 1.8
        try {
            lookup = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, int.class);
            lookup.setAccessible(true);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(
                    "There is no 'Lookup(Class, int)' method in java.lang.invoke.MethodHandles.",
                    e);
        } catch (Exception e) {
            lookup = null;
        }
        lookupConstructor = lookup;
    }

    public Object getInstance(Object target) {
        this.target = target;
        Class clazz = this.target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),
                clazz.getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return new DefaultPlayerMethodInvoker(getMethodHandle(method)).invoke(proxy, method, args);
    }

    private MethodHandle getMethodHandle(Method method)
            throws IllegalAccessException, InstantiationException, InvocationTargetException {
        final Class<?> declaringClass = method.getDeclaringClass();
        return lookupConstructor.newInstance(declaringClass, ALLOWED_MODES).unreflectSpecial(method, declaringClass);
    }

    interface PlayerMethodInvoker {
        Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
    }

    private static class DefaultPlayerMethodInvoker implements PlayerMethodInvoker {
        private final MethodHandle methodHandle;

        public DefaultPlayerMethodInvoker(MethodHandle methodHandle) {
            this.methodHandle = methodHandle;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return methodHandle.bindTo(proxy).invokeWithArguments(args);
        }
    }
}
