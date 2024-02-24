package com.ajkermenu.ajker.module.menu.controller;

import com.ajkermenu.ajker.base.Response;
import com.ajkermenu.ajker.module.menu.dto.ResponseForDayAmount;
import com.ajkermenu.ajker.module.menu.model.Transaction;
import com.ajkermenu.ajker.module.menu.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public Response<List<Transaction>> getAllTransactions() {
        return new Response<>("get all transaction successfully.",transactionService.getAllTransactions());
    }

    @GetMapping("/{transactionId}")
    public Transaction getTransactionById(@PathVariable String transactionId) {
        return transactionService.getTransactionById(transactionId);
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }

    @GetMapping("/amount/{date}")
    public List<Transaction> getTransactionByDate(@PathVariable("date") String date) {
        return transactionService.getTransactionByDate(date);
    }

    @GetMapping("/day-amount/{date}")
    public List<ResponseForDayAmount> getAllChefEarnedAmount(@PathVariable("date") String date) {
        return transactionService.getAllChefEarnedAmount(date);
    }

    @GetMapping("/day-amount/{date}/{chefId}")
    public ResponseForDayAmount getChefEarnedAmountById(@PathVariable("date") String date, @PathVariable("chefId") String chefId) {
        return transactionService.getChefEarnedAmountById(date,chefId);
    }

}
