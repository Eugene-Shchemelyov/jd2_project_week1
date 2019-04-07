package com.gmail.eugene.shchemelyov.repository;

import java.util.List;

public interface FileRepository {

    List<String> getFileContent(String fileName);
}
