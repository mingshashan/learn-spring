package com.mingshashan.learn.es.controller;

import com.mingshashan.learn.es.entity.Book;
import com.mingshashan.learn.es.service.IBookService;
import com.mingshashan.learn.es.vo.BookRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * BookController
 * @author jasonxu
 */
@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    /**
     * 列表分页查询
     */
    @GetMapping("/list")
    public ResponseEntity<Page<Book>> list(BookRequestVO bookRequestVO, Pageable pageable) {
        Page<Book> page = bookService.list(bookRequestVO, pageable);
        return ResponseEntity.ok(page);
    }

    /**
     * 查看文档
     */
    @GetMapping("/detail")
    public ResponseEntity<Book> detail(Long id) {
        Book book = bookService.detail(id);
        return ResponseEntity.ok(book);
    }

    /**
     * 添加文档
     */
    @PostMapping("/add")
    public ResponseEntity<Book> add(@RequestBody Book book) {
        Book savedBook = bookService.save(book);
        log.info("插入文档成功！请求参数: {}", book);
        return ResponseEntity.ok(savedBook);
    }

    /**
     * 修改文档
     */
    @PostMapping("/update")
    public ResponseEntity<Book> update(@RequestBody Book book) {
        Book updatedBook = bookService.update(book);
        log.info("更新文档成功！请求参数: {}", book);
        return ResponseEntity.ok(updatedBook);
    }

    /**
     * 删除文档
     */
    @GetMapping("/delete")
    public void delete(Long id) {
        bookService.delete(id);
    }

}