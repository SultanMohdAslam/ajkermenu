package com.ajkermenu.ajker.module.menu.repository;

import com.ajkermenu.ajker.module.menu.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order,String> {
    Order findByOrderId(String orderId);

    List<Order> findByOrderIdIn(List<String> orderIds);
}
