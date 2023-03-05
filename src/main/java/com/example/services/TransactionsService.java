package com.example.services;

import com.example.models.Transaction;
import com.example.models.enums.Color;
import com.example.models.enums.Size;
import com.example.models.enums.TypeTransaction;

import javax.annotation.PostConstruct;
import java.util.List;

public interface TransactionsService {
    @PostConstruct
    void init();


    void addTransactions(TypeTransaction typeTransaction,
                         int socksQuantity,
                         Size size,
                         int cotton,
                         Color color);

    List<Transaction> getAllTransactions();
}
