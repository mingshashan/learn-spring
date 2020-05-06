package com.mingshashan.learn.alibaba.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.RequestWrapper;

/**
 * TestController
 *
 * @author jasonxu
 */
@RequestMapping("test")
public class TestController {

    @GetMapping("hello")
    public String hello() {
        return "Hello";
    }
}
