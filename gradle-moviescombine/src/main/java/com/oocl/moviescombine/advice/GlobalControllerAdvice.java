package com.oocl.moviescombine.advice;

import com.oocl.moviescombine.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NoSessionFoundException.class})
    public ErrorResponse handleSessionNotFound(Exception exception) {
        return new ErrorResponse(404, "Session is Not Found");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NoPaymentFoundException.class})
    public ErrorResponse handlePaymentNotFound(Exception exception) {
        return new ErrorResponse(404, "Payment cannot proceed. Your selected seats are reserved by others.");
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NoMovieFoundException.class})
    public ErrorResponse handleNoMovieFound(Exception exception) {
        return new ErrorResponse(404, "No Movie Found. Try with another id");
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({WrongPasswordException.class})
    public ErrorResponse handleWrongPassword(Exception exception) {
        return new ErrorResponse(403, "Wrong Password or Password not yet set.");
    }
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({PasswordCreateException.class})
    public ErrorResponse handlePasswordCreate(Exception exception) {
        return new ErrorResponse(403, "Empty password is not allowed or Password is set before.");
    }
}
