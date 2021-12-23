package com.oocl.moviescombine.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.stream.Collectors;

public class ReserveSeatRequest {
    private List<String> seatNumbers;
    private String operation;

    public ReserveSeatRequest() {
    }

    public ReserveSeatRequest(List<String> seatNumbers, String operation) {
        this.seatNumbers = seatNumbers;
        this.operation = operation;
    }

    public List<String> getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(List<String> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public List<Integer> seatNumberConvertIndex(){
        return seatNumbers.stream().map(item -> (item.charAt(0) - 'A') * 11 + ( Integer.parseInt(item.substring(1)) - 1)).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "ReserveSeatRequest{" +
                "seatNumbers=" + seatNumbers +
                ", operation='" + operation + '\'' +
                '}';
    }
}
