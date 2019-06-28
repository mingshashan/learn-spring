package com.mingshashan.learn.es.service.impl;

import com.mingshashan.learn.es.entity.Book;
import com.mingshashan.learn.es.repository.BookRepository;
import com.mingshashan.learn.es.service.IBookService;
import com.mingshashan.learn.es.utils.CommonErrorCoded;
import com.mingshashan.learn.es.vo.BookRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;


/**
 * BookServiceImpl
 *
 * @author jasonxu
 */
@Slf4j
@Service
public class BookServiceImpl implements IBookService {
    
    @Autowired
    private RestHighLevelClient client;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<Book> list(BookRequestVO bookRequestVO, Pageable pageable) {

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if (!ObjectUtils.isEmpty(bookRequestVO.getId())) {
            QueryBuilder idQueryBuilder = QueryBuilders.matchQuery("id", bookRequestVO.getId());
            boolQueryBuilder.must(idQueryBuilder);
        }
        if (StringUtils.isNotBlank(bookRequestVO.getName())) {
            QueryBuilder nameQueryBuilder = QueryBuilders.fuzzyQuery("name", bookRequestVO.getName());
            boolQueryBuilder.must(nameQueryBuilder);
        }

        if (StringUtils.isNotBlank(bookRequestVO.getAuthor())) {
            QueryBuilder authorQueryBuilder = QueryBuilders.fuzzyQuery("author", bookRequestVO.getAuthor());
            boolQueryBuilder.must(authorQueryBuilder);
        }
        if (!ObjectUtils.isEmpty(bookRequestVO.getPrice())) {
            QueryBuilder priceQueryBuilder = QueryBuilders.rangeQuery("price").from(bookRequestVO.getPrice() - 10).to(bookRequestVO.getPrice() + 10);
            boolQueryBuilder.must(priceQueryBuilder);
        }
        if (StringUtils.isNotBlank(bookRequestVO.getCategories())) {
            String[] categoryArr = bookRequestVO.getCategories().split(",");
            List<Integer> categoryList = Arrays.asList(categoryArr).stream().map(e -> Integer.valueOf(e)).collect(Collectors.toList());
            BoolQueryBuilder categoryBoolQueryBuilder = QueryBuilders.boolQuery();
            for (Integer category : categoryList) {
                categoryBoolQueryBuilder.should(QueryBuilders.termQuery("category", category));
            }
            boolQueryBuilder.must(categoryBoolQueryBuilder);
        }

        Page<Book> bookPage = bookRepository.search(boolQueryBuilder, pageable);
        return bookPage;
    }

    @Override
    public Book save(Book book) {

        if (ObjectUtils.isEmpty(book)) {
            throw CommonErrorCoded.BOOK_PARAMETER_EMPTY.exception();
        }

        if (ObjectUtils.isEmpty(book.getId()) || 0 > book.getId()) {
            throw CommonErrorCoded.BOOK_PARAMETER_EMPTY.exception(book.getId());
        }

        Book savedBook = bookRepository.save(book);
        return savedBook;
    }

    @Override
    public Book update(Book book) {

        Book existedBook = bookRepository.findById(book.getId()).get();

        if (ObjectUtils.isEmpty(existedBook)) {
            throw CommonErrorCoded.BOOK_NOT_EXIST.exception(book.getId());
        }

        modelMapper.map(book, existedBook);
        return bookRepository.save(existedBook);
    }

    @Override
    public void delete(Long id) {

        Book existedBook = bookRepository.findById(id).get();
        if (ObjectUtils.isEmpty(existedBook)) {
            throw CommonErrorCoded.BOOK_NOT_EXIST.exception(id);
        }

        bookRepository.deleteById(id);
    }

    @Override
    public Book detail(Long id) {

        if (ObjectUtils.isEmpty(id) || 0 > id) {
            throw CommonErrorCoded.BOOK_ID_ERROR.exception(id);
        }
        return bookRepository.findById(id).orElseThrow((Supplier) () -> CommonErrorCoded.BOOK_NOT_EXIST.exception());
    }
}