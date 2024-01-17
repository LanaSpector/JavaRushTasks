package com.javarush.task.task22.task2201;

public class StringForFirstThreadTooShortException extends RuntimeException {
    public StringForFirstThreadTooShortException(Exception e) {
        super(e);
    }
}

