package com.mingshashan.learn.begin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
