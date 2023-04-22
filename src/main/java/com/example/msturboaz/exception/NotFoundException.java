package com.example.msturboaz.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
@RequiredArgsConstructor
@Getter
public class NotFoundException extends RuntimeException{
    private String code;

    public NotFoundException(String message, String code) {
        super(message);
        this.code = code;
    }
}
