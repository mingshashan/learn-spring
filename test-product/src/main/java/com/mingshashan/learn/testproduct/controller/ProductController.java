package com.mingshashan.learn.testproduct.controller;

import com.mingshashan.learn.testproduct.model.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ProductController
 *
 * @author jasonxu
 */
@RestController
@RequestMapping("products")
public class ProductController {

    private final RestTemplate restTemplate;

    public ProductController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping
    public Product getProductByCode(@RequestParam(name = "code") String code) {

        Product product = new Product();
        product.setId(3142);
        product.setCode(code);
        product.setName("《三国演义》");

        Object stockResult = restTemplate.getForObject("http://localhost:17073/stocks", String.class);

        return product;
    }
}
