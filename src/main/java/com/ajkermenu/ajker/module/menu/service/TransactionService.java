package com.ajkermenu.ajker.module.menu.service;


import com.ajkermenu.ajker.exception.ItemNotFoundException;
import com.ajkermenu.ajker.module.menu.dto.ResponseForDayAmount;
import com.ajkermenu.ajker.module.menu.model.Order;
import com.ajkermenu.ajker.module.menu.model.Transaction;
import com.ajkermenu.ajker.module.menu.repository.CustomerRepository;
import com.ajkermenu.ajker.module.menu.repository.OrderRepository;
import com.ajkermenu.ajker.module.menu.repository.TransactionRepository;
import com.ajkermenu.ajker.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;


    public TransactionService(TransactionRepository transactionRepository, OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.transactionRepository = transactionRepository;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
    public Transaction getTransactionById(String transactionId) {
        log.info("*** Method getTransactionById started ***");
        return transactionRepository.findByTransactionId(transactionId);
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionByDate(String fromDate) {
        log.info("*** Method getTransactionByDate started ***");
        return transactionRepository.findByTransactionAtStartingWith(fromDate, DateUtils.incrementDate(fromDate));
    }

    public List<ResponseForDayAmount> getAllChefEarnedAmount(String date) {

        log.info("*** Method getAllChefEarnedAmount started ***");
        List<ResponseForDayAmount> responseForDayAmounts = new ArrayList<>();

        List<Order> orders = getOderByDate(date);
        if(orders != null && !orders.isEmpty()) {
            Set<String> chefIdSet = orders.stream().map(Order::getChefId).collect(Collectors.toSet());

            chefIdSet.forEach( id ->{
                        Integer amount = orders.stream()
                                .filter(order -> order.getChefId().equals(id))
                                .mapToInt(Order::getAmount)
                                .sum();
                        String name = customerRepository.findByCustomerId(id).getName();
                        ResponseForDayAmount responseForDayAmount = new ResponseForDayAmount(name,amount);
                        responseForDayAmounts.add(responseForDayAmount);
                    }
            );
        }
        log.info("*** Method getChefEarnedAmountById ended ***");
        return responseForDayAmounts;
    }

    public ResponseForDayAmount getChefEarnedAmountById(String date, String chefId) {

        log.info("*** Method getChefEarnedAmountById started ***");
        ResponseForDayAmount responseForDayAmount = null;

        List<Order> orders = getOderByDate(date);

        if(orders != null && !orders.isEmpty()){
            Integer amount = orders.stream()
                    .filter(order -> order.getChefId().equals(chefId))
                    .mapToInt(Order::getAmount)
                    .sum();
            String name = customerRepository.findByCustomerId(chefId).getName();
            responseForDayAmount = new ResponseForDayAmount(name,amount);
        }

        log.info("*** Method getChefEarnedAmountById ended ***");
        return responseForDayAmount;
    }

    public List<Order> getOderByDate(String date){

        log.info("*** Method getOderByDate started ***");
        List<Transaction> transactions = getTransactionByDate(date);
        List<String> orderIds = transactions.stream().map(Transaction::getOrderId).toList();
        return orderRepository.findByOrderIdIn(orderIds);
    }
}
