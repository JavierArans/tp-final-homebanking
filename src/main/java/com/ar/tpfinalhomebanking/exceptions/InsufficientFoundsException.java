package com.ar.tpfinalhomebanking.exceptions;

public class InsufficientFoundsException extends RuntimeException{
    public InsufficientFoundsException(String message) {
        super(message);
    }
}
