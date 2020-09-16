package com.example.demo.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {
    public static void main(String args[]) throws Exception {

        UnsafeClass Unsafe = new UnsafeClass();
        Unsafe.name = "hacked by ph0rse";

        FileOutputStream fos = new FileOutputStream("/Users/jasonxu/build/01.code/11.learn/26.java/15.learn-spring/demo/object");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        //writeObject()方法将Unsafe对象写入object文件
        os.writeObject(Unsafe);
        os.close();
        //从文件中反序列化obj对象
        FileInputStream fis = new FileInputStream("/Users/jasonxu/build/01.code/11.learn/26.java/15.learn-spring/demo/object");
        ObjectInputStream ois = new ObjectInputStream(fis);
        //恢复对象
        UnsafeClass objectFromDisk = (UnsafeClass) ois.readObject();
        System.out.println(objectFromDisk.name);
        ois.close();
    }

}