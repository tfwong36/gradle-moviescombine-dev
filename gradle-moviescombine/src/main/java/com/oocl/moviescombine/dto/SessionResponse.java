package com.oocl.moviescombine.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class SessionResponse {
    private String id;
    private String cinemaId;
    private String movieId;
    private LocalDateTime showDateTimeHkt;
    private double price;
    private Boolean hasRemainSeat;
    private LocalDate date;
    private LocalTime time;

    public SessionResponse() {
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
        this.setDate(showDateTimeHkt.toLocalDate());
        this.setTime(showDateTimeHkt.toLocalTime());
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Boolean getHasRemainSeat() {
        return hasRemainSeat;
    }

    public void setHasRemainSeat(Boolean hasRemainSeat) {
        this.hasRemainSeat = hasRemainSeat;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
