package com.gmail.eugene.shchemelyov.service;

import com.gmail.eugene.shchemelyov.service.exception.NotNullStringException;
import com.gmail.eugene.shchemelyov.service.impl.FileServiceImpl;
import org.junit.Test;

public class FileServiceTest {

    @Test(expected = NotNullStringException.class)
    public void shouldNotNullFileNameString() {
        FileService fileService = FileServiceImpl.getInstance();
        fileService.getFileContentString(null);
    }

}
