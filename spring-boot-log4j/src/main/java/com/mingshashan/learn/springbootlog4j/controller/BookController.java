package com.mingshashan.learn.springbootlog4j.controller;

import com.mingshashan.learn.springbootlog4j.model.Book;
import com.mingshashan.learn.springbootlog4j.repository.BookRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * BookController
 *
 * @author jasonxu
 */
@RestController
@RequestMapping("books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public Book save(@RequestParam("name") String name) {
        Book book = new Book();
        book.setName(name);
        return bookRepository.save(book);
    }
}
