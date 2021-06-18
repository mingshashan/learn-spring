package com.mingshashan.learn.testorder.service;

import com.imadcn.framework.idworker.spring.schema.handler.IdworkerNamespaceHandler;
import com.mingshashan.learn.testorder.model.Order;
import com.mingshashan.learn.testorder.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;

/**
 * OrderService
 *
 * @author jasonxu
 */
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final RestTemplate restTemplate;

    public OrderService(OrderRepository orderRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    public Order create(Order order) {
        return orderRepository.save(order);
    }

    public Collection<Order> getAll() {

        Object obj = restTemplate.getForEntity("http://localhost:17071/products?code=11", Object.class);

        return orderRepository.getAll();
    }
}
