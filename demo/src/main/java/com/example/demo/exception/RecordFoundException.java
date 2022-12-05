package com.example.demo.exception;

public class RecordFoundException extends RuntimeException{
    public RecordFoundException(String message) {
        super(message);
    }
}
