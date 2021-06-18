package com.mingshashan.learn.es.repository;

import com.mingshashan.learn.es.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * BookRepository
 *
 * @author jason
 */
public interface BookRepository extends ElasticsearchRepository<Book, Long> {

    Book findByAuthorOrCategoryOrName(String author, String category, String name);
}
