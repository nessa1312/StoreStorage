package com.example.controllers;

import com.example.models.Socks;
import com.example.models.Transaction;
import com.example.services.TransactionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionsController {

    private TransactionsService transactionsService;

    public TransactionsController(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @GetMapping("/allTransactions")
    public ResponseEntity<List<Transaction>> getAllSocksList() {
        return ResponseEntity.ok().body(transactionsService.getAllTransactions());
    }


}
