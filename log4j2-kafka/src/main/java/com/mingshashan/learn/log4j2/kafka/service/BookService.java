package com.mingshashan.learn.log4j2.kafka.service;

import com.mingshashan.learn.log4j2.kafka.model.Book;
import com.mingshashan.learn.log4j2.kafka.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * BookService
 *
 * @author jasonxu
 */
@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {

        logger.info("add book {}", book);
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        logger.info("delete book by id，id = {}", id);
        bookRepository.deleteById(id);
    }

    public Collection<Book> findAll() {
        logger.info("find all book");
        return bookRepository.findAll();
    }
}
