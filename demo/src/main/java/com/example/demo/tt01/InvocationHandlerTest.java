package com.example.demo.tt01;

import java.lang.reflect.Method;

/**
 * @author mingshashan
 */
public class InvocationHandlerTest {

    public static void main(String[] args) throws Throwable {
        DemoInvocationHandler invocationHandler = new DemoInvocationHandler();
        SendMsg sendMsg = new SendMsg();

        Method method =
                SendMsg.class.getDeclaredMethod("send", String.class);
        String msg = "hello";
        Object[] objects = new Object[1];
        objects[0] = msg;
        String result = (String) invocationHandler.invoke(sendMsg, method, objects);
        System.out.println(result);
    }

}
