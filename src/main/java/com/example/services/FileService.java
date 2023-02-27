package com.example.services;

import com.example.models.Socks;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public interface FileService {

    boolean saveToFile(String fileName, Map<? extends Number, ? extends Object> hashMap);

    boolean cleanFile(String fileName);

    String readFile(String fileName);

    Path createTempFile(String suffix);

    Path createTxtFile(Map<Integer, Socks> storage) throws IOException;
}
