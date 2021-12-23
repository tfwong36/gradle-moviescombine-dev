package com.oocl.moviescombine.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CreateSessionRequest {
    private String cinemaId;
    private String movieId;
    private LocalDateTime showDateTimeHkt;
    private double price;
    private Integer rowLen;
    private Integer colLen;

    public CreateSessionRequest() {
    }

    public CreateSessionRequest(String cinemaId, String movieId, LocalDateTime showDateTimeHkt, double price, Integer rowLen, Integer colLen) {
        this.cinemaId = cinemaId;
        this.movieId = movieId;
        this.showDateTimeHkt = showDateTimeHkt;
        this.price = price;
        this.rowLen = rowLen;
        this.colLen = colLen;
    }

    public String getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public LocalDateTime getShowDateTimeHkt() {
        return showDateTimeHkt;
    }

    public void setShowDateTimeHkt(LocalDateTime showDateTimeHkt) {
        this.showDateTimeHkt = showDateTimeHkt;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getRowLen() {
        return rowLen;
    }

    public void setRowLen(Integer rowLen) {
        this.rowLen = rowLen;
    }

    public Integer getColLen() {
        return colLen;
    }

    public void setColLen(Integer colLen) {
        this.colLen = colLen;
    }

    public List<String>getRemainingSeats(){
        ArrayList<String> remainingSeats = new ArrayList<String>();
        for (int rowIndex = 1; rowIndex <= this.rowLen; rowIndex++){
            for (int colIndex = 1; colIndex <= this.colLen; colIndex++){
                remainingSeats.add(String.valueOf((char)(rowIndex + 64)) + colIndex);
            }
        }
        return remainingSeats;
    }
}
