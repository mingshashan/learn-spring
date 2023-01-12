package com.mingshashan.learn.learnmybatis.cglib;

/**
 * @author mingshashan
 */
public class CglibMainDemo {

    public String method(String str) {
        System.out.println(str);
        return "CglibMainDemo: " + str;
    }

    public static void main(String[] args) {
        CglibProxyDemo cglibProxyDemo = new CglibProxyDemo();
        CglibMainDemo proxy = (CglibMainDemo) cglibProxyDemo.getProxy(CglibMainDemo.class);

        String result = proxy.method("哈哈只");
        System.out.println(result);
    }
}
