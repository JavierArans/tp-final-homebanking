package com.ar.tpfinalhomebanking.exceptions;

public class UserNotExistsException extends RuntimeException{

    public UserNotExistsException(String message){
        super(message);
    }
}
