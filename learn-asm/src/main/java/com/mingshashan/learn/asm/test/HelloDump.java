package com.mingshashan.learn.asm.test;

import org.objectweb.asm.*;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.lang.reflect.Method;

public class HelloDump implements Opcodes {


    public static void main(String[] args) throws Exception {
        HelloDump helloDump = new HelloDump();
        byte[] bytes = dump();

        FileCopyUtils.copy(bytes, new File("/Users/jasonxu/build/01.code/11.learn/26.java/15.learn-spring/learn-asm/Hello$Accessor.class"));
//        MyClassLoader classLoader = new MyClassLoader();
//        Class clazz = classLoader.loadClass("com.mingshashan.learn.asm.test.Hello");
//
//        Object hello = clazz.newInstance();
//        Method method = clazz.getMethod("add");
//        Object tt = method.invoke(hello, 1, 2);
//
//        System.out.println(tt);
    }

    public static byte[] dump() throws Exception {

        ClassWriter classWriter = new ClassWriter(0);
        FieldVisitor fieldVisitor;
        MethodVisitor methodVisitor;
        AnnotationVisitor annotationVisitor0;

        classWriter.visit(V1_8, ACC_PUBLIC | ACC_SUPER, "com/mingshashan/learn/asm/test/Hello$Accessor", null, "java/lang/Object", null);

        classWriter.visitSource("Hello$Accessor.java", null);

        {
            methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            methodVisitor.visitCode();
            Label label0 = new Label();
            methodVisitor.visitLabel(label0);
            methodVisitor.visitLineNumber(10, label0);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            methodVisitor.visitInsn(RETURN);
            Label label1 = new Label();
            methodVisitor.visitLabel(label1);
            methodVisitor.visitLocalVariable("this", "Lcom/mingshashan/learn/asm/test/Hello;", null, label0, label1, 0);
            methodVisitor.visitMaxs(1, 1);
            methodVisitor.visitEnd();
        }
        {
            methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "add", "(II)I", null, null);
            methodVisitor.visitParameter("a", 0);
            methodVisitor.visitParameter("b", 0);
            methodVisitor.visitCode();
            Label label0 = new Label();
            methodVisitor.visitLabel(label0);
            methodVisitor.visitLineNumber(13, label0);
            methodVisitor.visitVarInsn(ILOAD, 1);
            methodVisitor.visitVarInsn(ILOAD, 2);
            methodVisitor.visitInsn(IADD);
            methodVisitor.visitInsn(IRETURN);
            Label label1 = new Label();
            methodVisitor.visitLabel(label1);
            methodVisitor.visitLocalVariable("this", "Lcom/mingshashan/learn/asm/test/Hello;", null, label0, label1, 0);
            methodVisitor.visitLocalVariable("a", "I", null, label0, label1, 1);
            methodVisitor.visitLocalVariable("b", "I", null, label0, label1, 2);
            methodVisitor.visitMaxs(2, 3);
            methodVisitor.visitEnd();
        }
        classWriter.visitEnd();

        return classWriter.toByteArray();
    }
}
