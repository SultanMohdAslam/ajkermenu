package com.ajkermenu.ajker.module.menu.service;

import com.ajkermenu.ajker.module.menu.model.Order;
import com.ajkermenu.ajker.module.menu.model.Transaction;
import com.ajkermenu.ajker.module.menu.repository.OrderRepository;
import com.ajkermenu.ajker.module.menu.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final TransactionService transactionService;

    public OrderService(OrderRepository orderRepository, TransactionService transactionService) {
        this.orderRepository = orderRepository;
        this.transactionService = transactionService;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(String orderId) {
        return orderRepository.findByOrderId(orderId);
    }

    @Transactional
    public Order createOrder(Order order) {
        Order createdOrder = orderRepository.save(order);
        transactionService.createTransaction(new Transaction(new Date(),createdOrder.getOrderId()));
        return createdOrder;
    }
}
