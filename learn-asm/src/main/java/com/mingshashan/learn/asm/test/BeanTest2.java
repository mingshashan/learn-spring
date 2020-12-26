package com.mingshashan.learn.asm.test;

import org.objectweb.asm.*;

import java.io.FileOutputStream;

public class BeanTest2 extends ClassLoader implements Opcodes {

    public static void main(String[] args) throws Exception {
        ClassWriter cw = new ClassWriter(0);
        //类名
        cw.visit(V1_7, ACC_PUBLIC, "com/xxx/model/_766ComLeakInfo", null, "com/xxx/model/LeakInfo", null);
        //注释
        AnnotationVisitor av = cw.visitAnnotation("Lorg/springframework/data/mongodb/core/mapping/Document;", true);
        //注释参数
        av.visit("collection", "uc_members");
        av.visitEnd();
        //构造函数
        MethodVisitor mw = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        mw.visitVarInsn(ALOAD, 0);
        mw.visitMethodInsn(INVOKESPECIAL, "com/xxx/model/LeakInfo", "<init>", "()V");
        mw.visitInsn(RETURN);
        mw.visitMaxs(1, 1);
        mw.visitEnd();


        //字段
        FieldVisitor fv = cw.visitField(ACC_PUBLIC, "description", "Ljava/lang/String;", null, null);
        fv.visitEnd();

        byte[] code = cw.toByteArray();

        //将二进制流写到本地磁盘上
        FileOutputStream fos = new FileOutputStream("E:/asm/bin/com/xxx/model/_766ComLeakInfo.class");
        fos.write(code);
        fos.close();

        BeanTest2 loader = new BeanTest2();
        Class<?> clazz = loader.defineClass(null, code, 0, code.length);
        Object beanObj = clazz.getConstructor().newInstance();


        clazz.getField("description").set(beanObj, "Adobe客户信息泄露!");

        String nameString = (String) clazz.getField("description").get(beanObj);
        System.out.println("filed value : " + nameString);
    }
}