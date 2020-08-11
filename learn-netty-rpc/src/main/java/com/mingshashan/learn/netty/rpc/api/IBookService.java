package com.mingshashan.learn.netty.rpc.api;

import java.util.List;

/**
 * IBookService
 *
 * @author jasonxu
 */
public interface IBookService {
    List<BookVO> getBooks();
}
