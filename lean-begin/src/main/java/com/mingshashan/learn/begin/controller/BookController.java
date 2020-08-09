package com.mingshashan.learn.begin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * UserController
 *
 * @author jasonxu
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping()
    public List<BookVO> books() {
        System.out.println("get books");
        List<BookVO> bookVOS = new ArrayList<>();
        bookVOS.add(new BookVO("《三国演义》"));
        bookVOS.add(new BookVO("《西游记》"));
        bookVOS.add(new BookVO("《水浒传》"));
        bookVOS.add(new BookVO("《红楼梦》"));
        return bookVOS;
    }
}
