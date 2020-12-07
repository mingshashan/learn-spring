package com.mingshashan.learn.begin.controller;

import org.springframework.web.bind.annotation.*;

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
