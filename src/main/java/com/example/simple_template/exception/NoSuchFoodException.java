package com.example.simple_template.exception;

public class NoSuchFoodException extends RuntimeException {
    public NoSuchFoodException(String message) {
        super("No such element in database");
    }
}
