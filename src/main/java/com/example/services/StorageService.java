package com.example.services;

import com.example.exceptions.QuantityException;
import com.example.models.Socks;
import com.example.models.enums.Color;
import com.example.models.enums.Size;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

public interface StorageService {
    @PostConstruct
    void init();

    void addSocksInStorage(Socks socks) throws QuantityException;

    abstract List<Socks> obtainAllSocks();

    Map<Integer, Socks> obtainMapAllSocks();

    int getFromStock(Socks socks) throws QuantityException;

    int deleteFromStock(Socks socks) throws QuantityException;

    int availabilityCheck(Color color,
                          Size size,
                          int cottonMin,
                          int cottonMax);

}
