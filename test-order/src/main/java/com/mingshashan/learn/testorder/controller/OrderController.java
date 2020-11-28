package com.mingshashan.learn.testorder.controller;

import com.mingshashan.learn.testorder.model.Order;
import com.mingshashan.learn.testorder.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * OrderController
 *
 * @author jasonxu
 */
@Tag(name = "order管理")
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    private Order create(Order order) {
        return orderService.create(order);
    }

    @GetMapping("/all")
    private Collection<Order> getAll() {
        return orderService.getAll();
    }
}
