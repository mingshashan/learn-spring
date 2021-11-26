package com.mingshashan.learn.hello.controller;

import com.mingshashan.learn.hello.service.BookService;
import com.mingshashan.learn.hello.vo.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * BookController
 *
 * @author xufj
 */
@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Book getBook() {
        Book book = new Book("1" ,"《佛本是道》", "郑贺志");
        return book;
    }

    @GetMapping("test")
    public String test() {
        return bookService.queryBooks(new Book());
    }
}
