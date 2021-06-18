package com.mingshashan.learn.teststock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * StockController
 *
 * @author jasonxu
 */
@RestController
@RequestMapping("stocks")
public class StockController {

    @GetMapping("")
    public String test() {
        return "hello";
    }
}
