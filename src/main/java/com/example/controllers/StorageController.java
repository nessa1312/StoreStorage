package com.example.controllers;

import com.example.exceptions.QuantityException;
import com.example.models.Socks;
import com.example.models.enums.*;
import com.example.services.StorageService;
import com.example.services.TransactionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/storage")
public class StorageController {

    StorageService storageService;

    TransactionsService transactionsService;

    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping()
    public ResponseEntity<Socks[]> addSocksInStorage(@Valid @RequestBody Socks...socks) throws QuantityException {
        for (Socks sock : socks) {
            storageService.addSocksInStorage(sock);
        }
        return ResponseEntity.ok(socks);
    }

    @GetMapping("/allSocks")
    public ResponseEntity<List<Socks>> getAllSocksList() {
        return ResponseEntity.ok(storageService.obtainAllSocks());
    }

    @GetMapping("/quantity")

    public ResponseEntity<Integer> obtainQuantity(Color color,
                                                  Size size,
                                                  int cottonMin,
                                                  int cottonMax) {

        int quantity = storageService.availabilityCheck(color, size, cottonMin, cottonMax);

        return ResponseEntity.ok(quantity);
    }

    @PutMapping
    public ResponseEntity<Object> getFromStock(@Valid @RequestBody Socks socks) {
        int a = 0;
        try {
            a = storageService.getFromStock(socks);
        } catch (QuantityException e) {
            ResponseEntity.badRequest().body(e);
        }

        return ResponseEntity.ok().body("На складе осталось " + a);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteFromStock(@Valid @RequestBody Socks socks) {
        int a = 0;
        try {
            a = storageService.deleteFromStock(socks);
        } catch (QuantityException e) {
            ResponseEntity.badRequest().body(e);
        }

        return ResponseEntity.ok().body("На складе осталось " + a);
    }
}
