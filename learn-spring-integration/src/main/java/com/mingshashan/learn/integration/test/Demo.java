package com.mingshashan.learn.integration.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Demo
 *
 * @author xufj
 */
public class Demo {

    public static void main(String[] args) {

//        ist list1 = Stream.of(1,2,3,4,5,6,7,8,9,10)
//                .collect(() -> new ArrayList<Integer>(),.//生成一个新的ArrayList实例
//        //接受两个参数，第一个是前面生成的ArrayList对象，
//        //二个是stream中包含的元素，函数体就是把stream中的元素加入ArrayList对象中。
//        //此函数被反复调用直到原stream的元素被消费完毕；
//        (list, item) -> list.add(item),
//                //接受两个参数，这两个都是ArrayList类型的，函数体就是把第二个ArrayList全部加入到第一个中；
//                (lista, listb) -> lista.addAll(listb));

        List list1 = Stream.of(1,2,3,4,5,6,7,8,9,10)
                .collect(() -> new ArrayList<Integer>(),
                (list, item) -> list.add(item),
                (lista, listb) -> lista.addAll(listb));

//        System.out.println(list1);
        List list2 = Stream.of(1,2,3,4,5,6,7,8,9,10)
                .collect(ArrayList::new,
                        ArrayList::add,
                        ArrayList::addAll);
        List list3 =  Stream.of(1,2,3,4,5,6,7,8,9,10)
                .collect(Collectors.toList());
        System.out.println(list3);

//        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//                .stream()
//                .reduce((a, b) -> a + b)
//                .ifPresent(System.out::println);
//        System.out.println(Stream.of("A", "B", "C", "D")
//                .reduce("Str", (a, b) -> a + "-" + b));
//        System.out.println(Stream.of("I", "love", "you")
//                .reduce(0,// 初始值　
//                        (sum, str) -> sum + str.length(),// 累加操作
//                        (a, b) -> 0)); //并行stream才会用到
    }
}
