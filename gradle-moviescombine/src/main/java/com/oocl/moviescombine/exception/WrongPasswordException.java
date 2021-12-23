package com.oocl.moviescombine.exception;

public class WrongPasswordException extends RuntimeException{
    public WrongPasswordException() {
        super("Wrong password or Password not yet set");
    }
}
