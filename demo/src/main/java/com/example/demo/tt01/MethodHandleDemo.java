package com.example.demo.tt01;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author mingshashan
 */
public class MethodHandleDemo {

    public String sayHello(String msg1, String msg2) {
        return "Hello " + msg1 + ", " + msg2;
    }

    public static void main(String[] args) throws Throwable {
        MethodHandleDemo sub = new SubMethodHandlerDemo();

        MethodType methodType = MethodType.methodType(String.class, String.class, String.class);
        MethodHandle methodHandle = MethodHandles
                .lookup().findVirtual(MethodHandleDemo.class, "sayHello", methodType);

        System.out.println(methodHandle.bindTo(sub)
                .invokeWithArguments("小明", "小张"));

        MethodHandleDemo parent = new MethodHandleDemo();

        System.out.println(methodHandle.bindTo(parent)
        .invokeWithArguments("Json", "Mike"));
    }

    static class SubMethodHandlerDemo extends MethodHandleDemo {
        @Override
        public String sayHello(String msg1, String msg2) {
            return "Sub Hello " + msg1 + ", " + msg2;
        }
    }
}
