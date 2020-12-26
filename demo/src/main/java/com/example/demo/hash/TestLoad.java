package com.example.demo.hash;

/**
 * TestLoad
 *
 * @author xufj
 */
public class TestLoad {

    public static void main(String[] args) {
        try {
            ClassLoader.getSystemClassLoader().loadClass("com.example.demo.hash.ClassForName");

            System.out.println("#########分割符(上面是Class.forName的加载过程，下面是ClassLoader的加载过程)##########");
            Class.forName("com.example.demo.hash.ClassForName");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
