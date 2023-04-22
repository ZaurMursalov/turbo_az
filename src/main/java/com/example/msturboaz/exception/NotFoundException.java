package com.example.msturboaz.exception;

import org.springframework.data.crossstore.ChangeSetPersister;

public class NotFoundException extends RuntimeException{
    private String code;

    public NotFoundException(String message, String code) {
        super(message);
        this.code = code;
    }
}
