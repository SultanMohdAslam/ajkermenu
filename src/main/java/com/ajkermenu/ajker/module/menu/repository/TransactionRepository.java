package com.ajkermenu.ajker.module.menu.repository;

import com.ajkermenu.ajker.module.menu.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction,String> {
    Transaction findByTransactionId(String transactionId);

    @Query(value = "{ \"transactionAt\": { \"$gte\": {$date: ?0}, \"$lt\": {$date: ?1} } }")
    List<Transaction> findByTransactionAtStartingWith(String transactionAt , String toDate);

    List<Transaction> findByTransactionAt(Date transactionAt);

}
