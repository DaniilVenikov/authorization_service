package com.example.authorization_service.exception;

public class UnauthorizedUser extends RuntimeException{
    public UnauthorizedUser(String msg) {
        super(msg);
    }
}
