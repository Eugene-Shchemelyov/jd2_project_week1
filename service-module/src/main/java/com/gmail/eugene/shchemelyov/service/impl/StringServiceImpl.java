package com.gmail.eugene.shchemelyov.service.impl;

import com.gmail.eugene.shchemelyov.service.StringService;
import com.gmail.eugene.shchemelyov.service.exception.NotNullStringException;
import com.gmail.eugene.shchemelyov.service.exception.NotStringNumbersValueException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public final class StringServiceImpl implements StringService {

    private Logger logger = LogManager.getLogger(StringServiceImpl.class);
    private static StringService instance;

    private StringServiceImpl() {
    }

    public static StringService getInstance() {
        if (instance == null) {
            instance = new StringServiceImpl();
        }
        return instance;
    }

    @Override
    public int getSumNumbers(String numbers) {
        checkNullString(numbers);
        if(numbers.equals("")){
            return 0;
        }
        String[] numbersString = splitStringToArray(numbers);
        int sum;
        try {
            if (numbersString.length <= 2) {
                sum = Arrays.stream(numbersString)
                        .mapToInt(Integer::valueOf)
                        .sum();
                return sum;
            } else {
                logger.error("String numbers length more than two");
                throw new NotStringNumbersValueException();
            }
        } catch (IllegalArgumentException e) {
            logger.error(String.format("Numbers not valid. %s", e.getMessage()));
            throw new NotStringNumbersValueException();
        }
    }

    private void checkNullString(String string) {
        if (string == null) {
            logger.error("String is null");
            throw new NotNullStringException();
        }
    }

    private String[] splitStringToArray(String string) {
        String[] numbersString = new String[1];
        if (string.contains(",")) {
            numbersString = string.split(",");
        } else if (string.contains("\n")) {
            numbersString = string.split("\n");
        } else if (string.contains(":")) {
            numbersString = string.split(":");
        } else if (string.contains("|")) {
            numbersString = string.split("|");
        } else {
            numbersString[0] = string;
        }
        return numbersString;
    }
}
