package com.gmail.eugene.shchemelyov.web;

import com.gmail.eugene.shchemelyov.service.FileService;
import com.gmail.eugene.shchemelyov.service.impl.FileServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {

    public static void main(String[] args) {
        FileService fileService = FileServiceImpl.getInstance();
        String fileName = "file.txt";
        String fileContent = fileService.getFileContentString(fileName);
        Logger logger = LogManager.getLogger();
        logger.info(String.format("File content: %s", fileContent));
    }
}
