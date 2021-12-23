package com.oocl.moviescombine.exception;

public class NoSessionFoundException extends RuntimeException{
    public NoSessionFoundException() {
        super("No Session is found");
    }
}
