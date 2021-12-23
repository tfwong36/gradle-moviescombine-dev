package com.oocl.moviescombine.exception;

public class PasswordCreateException extends RuntimeException{
    public PasswordCreateException() {
        super("Empty password or Password is set before");
    }
}
