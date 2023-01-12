package com.mingshashan.learn.learnmybatis.javassist;

public class JavassistDemo {
    private String demoProperty = "demo-value"; // 字段

    // demoProperty字段对应的getter/setter方法
    public String getDemoProperty() {
        return demoProperty;
    }

    public void setDemoProperty(String demoProperty) {
        this.demoProperty = demoProperty;
    }

    // JavassistDemo的成员方法
    public void operation() {
        System.out.println("operation():" + this.demoProperty);
    }
}