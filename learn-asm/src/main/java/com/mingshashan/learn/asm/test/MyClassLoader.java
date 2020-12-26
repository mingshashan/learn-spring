package com.mingshashan.learn.asm.test;

/**
 * MyClassLoader
 *
 * @author xufj
 */
public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        if ("com.mingshashan.learn.asm.test.Hello".equals(name)) {
            try {
                byte[] bytes = HelloDump.dump();
                return defineClass(name, bytes, 0, bytes.length - 1);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return super.loadClass(name, resolve);
    }
}
