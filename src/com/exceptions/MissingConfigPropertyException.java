package com.exceptions;

public class MissingConfigPropertyException extends RuntimeException {

    private static final long serialVersionUID = -9208519269174474512L;

    public MissingConfigPropertyException(String message) {
        super(message);
    }
    
}