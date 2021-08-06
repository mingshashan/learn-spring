package com.mingshashan.learn.netty.nio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("A1", "AA"));
        students.add(new Student("B1", "BB"));
        students.add(new Student("C1", "CC"));


        students = null;
        Map<String, Student> studentMap =Optional.ofNullable(students)
                .orElse(new ArrayList<>())
                .stream().collect(Collectors.toMap(Student::getId, item->item));

        System.out.println(studentMap);
    }




}
