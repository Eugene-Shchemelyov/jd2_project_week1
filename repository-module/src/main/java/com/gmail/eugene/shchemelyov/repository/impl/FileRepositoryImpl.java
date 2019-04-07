package com.gmail.eugene.shchemelyov.repository.impl;

import com.gmail.eugene.shchemelyov.repository.FileRepository;
import com.gmail.eugene.shchemelyov.repository.exception.FileNotFoundException;
import com.gmail.eugene.shchemelyov.repository.exception.NotNullStringException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class FileRepositoryImpl implements FileRepository {

    private static FileRepository instance = null;
    private Logger logger = LogManager.getLogger(FileRepositoryImpl.class);

    private FileRepositoryImpl() {
    }

    public static FileRepository getInstance() {
        if (instance == null) {
            instance = new FileRepositoryImpl();
        }
        return instance;
    }

    @Override
    public List<String> getFileContent(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            logger.error("String is null");
            throw new NotNullStringException();
        }
        String filePath = "web-module/src/main/resources/" + fileName;
        String fileString;
        List<String> listFileStrings = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((fileString = br.readLine()) != null) {
                listFileStrings.add(fileString);
            }
        } catch (IOException e) {
            logger.error(String.format("File error %s. %s", fileName, e.getMessage()));
            throw new FileNotFoundException();
        }
        return listFileStrings;
    }
}
