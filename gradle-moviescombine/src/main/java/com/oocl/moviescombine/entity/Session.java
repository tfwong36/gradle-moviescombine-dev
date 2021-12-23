package com.oocl.moviescombine.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.List;

@Document
public class Session {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String cinemaId;

    private String movieId;
    private LocalDateTime showDateTimeHkt;
    private double price;
    private List<String> remainingSeats;
    // 11*9 dimension, each has available reserved selected
    // from left to right, A to I


    public Session() {
    }

    public Session(String cinemaId, String movieId, LocalDateTime showDateTimeHkt, double price, List<String> remainingSeats) {
        this.cinemaId = cinemaId;
        this.movieId = movieId;
        this.showDateTimeHkt = showDateTimeHkt;
        this.price = price;
        this.remainingSeats = remainingSeats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<String> getRemainingSeats() {
        return remainingSeats;
    }

    public void setRemainingSeats(List<String> remainingSeats) {
        this.remainingSeats = remainingSeats;
    }

}
