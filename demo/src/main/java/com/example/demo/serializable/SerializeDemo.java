package com.example.demo.serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeDemo {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.name = "员工甲";
        e.identify = "General staff";
        try {
            // 打开一个文件输入流
            FileOutputStream fileOut =
                    new FileOutputStream("/Users/jasonxu/build/01.code/11.learn/26.java/15.learn-spring/demo/employee1.db");
            // 建立对象输入流
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            //输出反序列化对象
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /Users/jasonxu/build/01.code/11.learn/26.java/15.learn-spring/demo/employee1.db");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}