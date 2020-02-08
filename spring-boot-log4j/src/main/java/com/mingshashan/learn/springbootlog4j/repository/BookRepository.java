package com.mingshashan.learn.springbootlog4j.repository;

import com.mingshashan.learn.springbootlog4j.model.Book;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * BookRepository
 *
 * @author jasonxu
 */
@Repository
public class BookRepository {

    private Logger logger = Logger.getLogger(BookRepository.class);

    private ConcurrentMap<Long, Book> books = new ConcurrentHashMap<>();

    private AtomicLong atomicId = new AtomicLong();

    public Book save(Book book) {
        if (logger.isDebugEnabled()) {
            logger.debug("save book, book.name = [" + book.getName() + "]");
        }
        Long id = atomicId.incrementAndGet();
        book.setId(id);
        books.putIfAbsent(id, book);
        logger.info("save book ok, book.name = [" + book.getName() + "]");
        return book;
    }
}
