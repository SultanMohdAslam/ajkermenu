package com.ajkermenu.ajker.module.menu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Collation("transaction")
public class Transaction {

    @Id
    private String transactionId;
    private Date transactionAt;
    private String orderId;
    public Transaction(Date transactionAt, String orderId) {
        this.transactionAt = transactionAt;
        this.orderId = orderId;
    }
}
