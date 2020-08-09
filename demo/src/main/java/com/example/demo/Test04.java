package com.example.demo;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Test04
 *
 * @author jasonxu
 */
public class Test04 {
    public static void main(String[] args) {
//        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(dateFormat.format(new Date()));
    }
}
