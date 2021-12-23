package com.oocl.moviescombine.exception;

public class NoMovieFoundException  extends RuntimeException{
    public NoMovieFoundException() {
        super("No Movie Found");
    }
}