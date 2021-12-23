package com.oocl.moviescombine.exception;

public class NoPaymentFoundException extends RuntimeException{
    public NoPaymentFoundException() {
        super("Cannot proceed Payment");
    }
}
