package com.gmail.eugene.shchemelyov.service;

import com.gmail.eugene.shchemelyov.service.exception.NotNullStringException;
import com.gmail.eugene.shchemelyov.service.exception.NotStringNumbersValueException;
import com.gmail.eugene.shchemelyov.service.impl.StringServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class StringServiceTest {

    @Test
    public void shouldReturnInteger() {
        String numbers = "11,11";
        StringService stringService = StringServiceImpl.getInstance();
        Integer sumNumbers = stringService.getSumNumbers(numbers);
        Assert.assertNotNull(sumNumbers);
    }

    @Test(expected = NotStringNumbersValueException.class)
    public void shouldInputStringNumbersLessThanThree() {
        String numbers = "11,11,11";
        StringService stringService = StringServiceImpl.getInstance();
        stringService.getSumNumbers(numbers);
    }

    @Test(expected = NotStringNumbersValueException.class)
    public void shouldInputStringContainIntegers() {
        String numbers = "ghp";
        StringService stringService = StringServiceImpl.getInstance();
        stringService.getSumNumbers(numbers);
    }

    @Test(expected = NotStringNumbersValueException.class)
    public void shouldInputStringContainTrueSeparators() {
        String numbers = "11*11";
        StringService stringService = StringServiceImpl.getInstance();
        stringService.getSumNumbers(numbers);
    }

    @Test(expected = NotNullStringException.class)
    public void shouldInputStringNotNull() {
        StringService stringService = StringServiceImpl.getInstance();
        stringService.getSumNumbers(null);
    }
}
