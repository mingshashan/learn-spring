package com.mingshashan.learn.testorder.repository;

import com.imadcn.framework.idworker.generator.CompressUUIDGenerator;
import com.imadcn.framework.idworker.generator.IdGenerator;
import com.mingshashan.learn.testorder.model.Order;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * OrderRepository
 *
 * @author jasonxu
 */
@Repository
public class OrderRepository {

    private final IdGenerator idGenerator = new CompressUUIDGenerator();
    private static final ConcurrentHashMap<Long, Order> repository = new ConcurrentHashMap();

    public synchronized Order save(Order order) {

        Long id = idGenerator.nextId();
        order.setId(id);
        repository.put(id, order);
        return order;
    }

    public Collection<Order> getAll() {
        return repository.values();
    }
}
