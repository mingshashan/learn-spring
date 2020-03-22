package com.mingshashan.learn.webflux.controller;


import com.mingshashan.learn.webflux.controller.model.BookVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 *
 */
@RestController
public class HelloWebFluxController {

//    @GetMapping("/hello")
    public String hello() {
        return "Hello, WebFlux !";
    }

//    @GetMapping("/book")
    public Mono<BookVO> getBook() {
        BookVO bookVO = new BookVO();
        bookVO.setName("《红楼梦》");
        bookVO.setAuthor("曹雪芹");
        return Mono.just(bookVO);
    }


}