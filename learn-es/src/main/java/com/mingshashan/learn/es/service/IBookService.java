package com.mingshashan.learn.es.service;

import com.mingshashan.learn.es.entity.Book;
import com.mingshashan.learn.es.vo.BookRequestVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * IBookService
 *
 * @author jasonxu
 */
public interface IBookService {

    /**
     * 模糊查询
     * @param bookRequestVO
     * @param pageable
     * @return
     */
    Page<Book> list(BookRequestVO bookRequestVO, Pageable pageable);

    /**
     * add book
     * @param book
     * @return
     */
    Book save(Book book);

    /**
     * update book
     * @param book
     * @return
     */
    Book update(Book book);

    /**
     * delete book
     * @param id
     */
    void delete(Long id);

    /**
     * get book detail by id
     * @param id
     * @return
     */
    Book detail(Long id);
}
