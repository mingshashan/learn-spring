package com.mingshashan.learn.begin.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * UserController
 *
 * @author jasonxu
 */
@RestController
@RequestMapping
public class UserController {

    @GetMapping("users")
    public String usersss(String id) {

//        List<Integer> lists = new ArrayList<Integer>();
//        lists.add(3);
//        lists.add(13);
//        lists.add(2);
//        lists.add(23);
//        lists.add(32);
//        lists.add(532);
//        lists.add(2);
//        lists.add(43);
//
//        lists.sort(Integer::compareTo);

        System.out.println("users");
        return "haha";
    }

    @GetMapping("users/{id}")
    public String users(@PathVariable String id) {
        System.out.println("users" + id);
        return "user-" + id;
    }

    @PostMapping("users")
    public String haha() throws InterruptedException {

        Thread.sleep(5000L);
        return "haha";
    }
}
