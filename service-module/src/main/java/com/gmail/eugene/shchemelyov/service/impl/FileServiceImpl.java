package com.gmail.eugene.shchemelyov.service.impl;

import com.gmail.eugene.shchemelyov.repository.FileRepository;
import com.gmail.eugene.shchemelyov.repository.impl.FileRepositoryImpl;
import com.gmail.eugene.shchemelyov.service.FileService;
import com.gmail.eugene.shchemelyov.service.exception.NotNullStringException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public final class FileServiceImpl implements FileService {
    private static FileService instance = null;
    private Logger logger = LogManager.getLogger(FileServiceImpl.class);
    private FileRepository fileRepository = FileRepositoryImpl.getInstance();

    private FileServiceImpl() {
    }

    public static FileService getInstance() {
        if (instance == null) {
            instance = new FileServiceImpl();
        }
        return instance;
    }

    @Override
    public String getFileContentString(String fileName) {
        checkNullString(fileName);
        List<String> fileContentStrings = fileRepository.getFileContent(fileName);
        return getContentToString(fileContentStrings);
    }

    private void checkNullString(String fileName) {
        if (fileName == null) {
            logger.error("String is null");
            throw new NotNullStringException();
        }
    }

    private String getContentToString(List<String> listStrings) {
        StringBuilder stringBuilder = new StringBuilder();
        listStrings.forEach(string -> {
            stringBuilder.append(string);
            stringBuilder.append(",");
        });
        return stringBuilder.toString().trim().substring(0, stringBuilder.length() - 1);
    }
}
