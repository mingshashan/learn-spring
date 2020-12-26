package com.example.demo.hash;

/**
 * Test
 *
 * @author xufj
 */
public class Test {

    public static void main(String[] args) {
        Integer object = 10;
//        System.out.printf("%o", object);
//        System.out.printf("%s", Integer.toBinaryString(object));

//        System.out.println(object.hashCode());
//        System.out.println(object.hashCode());

//        int hash = hash(object);

//        System.out.println(hash);

//        System.out.println(hash >>> 16);

//        int x = x000;
//        int
        System.out.println(7 ^ 1);
//         111
//       ^ 01

    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
