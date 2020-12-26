package com.mingshashan.learn.integration.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TestStudent
 *
 * @author xufj
 */
public class TestStudent {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(3, "小明", "数学", 15));
        list.add(new Student(2, "小刘", "物理", 17));
        list.add(new Student(5, "小马", "化学", 15));
        list.add(new Student(32, "小张", "生物", 16));
        list.add(new Student(13, "小王", "地理", 14));
        list.add(new Student(332, "小六", "语文", 16));

        list.sort(Comparator.comparingInt(Student::getAge).reversed());
//        List<Student> newLists = list.stream().sorted((o1, o2) -> o1.getAge() - o1.getAge()).collect(Collectors.toList());
        List<Student> newLists = list.stream().sorted(Comparator.comparingInt(Student::getAge)).collect(Collectors.toList());
//        System.out.println(list);

        System.out.println(list);
    }
}
