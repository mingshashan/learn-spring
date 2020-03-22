package com.mingshashan.learn.log4j2.kafka.repository;

import com.mingshashan.learn.log4j2.kafka.model.Book;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * BookRepository
 *
 * @author jasonxu
 */
@Repository
public class BookRepository {

    private static final ConcurrentHashMap<Long, Book> books = new ConcurrentHashMap<>();

    public Book save(Book entity) {
        books.put(entity.getId(), entity);
        return entity;
    }

    public void deleteById(Long id) {
        books.remove(id);
    }

    public Collection<Book> findAll() {
        return books.values();
    }
}
