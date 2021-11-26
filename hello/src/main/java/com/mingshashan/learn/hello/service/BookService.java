package com.mingshashan.learn.hello.service;

import com.mingshashan.learn.hello.vo.Book;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.groups.Default;

@Service
@Validated(Default.class)
public class BookService {

    public String queryBooks(@Valid Book book) {
        return "HHHH";
    }
}
