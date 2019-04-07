package com.gmail.eugene.shchemelyov.repository;

import com.gmail.eugene.shchemelyov.repository.exception.FileNotFoundException;
import com.gmail.eugene.shchemelyov.repository.exception.NotNullStringException;
import com.gmail.eugene.shchemelyov.repository.impl.FileRepositoryImpl;
import org.junit.Test;

public class FileRepositoryTest {

    @Test(expected = NotNullStringException.class)
    public void shouldFileNameNotNull() {
        FileRepository fileRepository = FileRepositoryImpl.getInstance();
        fileRepository.getFileContent(null);
    }

    @Test(expected = NotNullStringException.class)
    public void shouldFileNameNotEmpty() {
        FileRepository fileRepository = FileRepositoryImpl.getInstance();
        fileRepository.getFileContent("");
    }

    @Test(expected = FileNotFoundException.class)
    public void shouldFileIsExists() {
        String fileName = "fi.txt";
        FileRepository fileRepository = FileRepositoryImpl.getInstance();
        fileRepository.getFileContent(fileName);
    }
}
