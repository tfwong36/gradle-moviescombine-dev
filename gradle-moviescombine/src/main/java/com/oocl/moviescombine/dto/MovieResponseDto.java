package com.oocl.moviescombine.dto;

import java.time.LocalDate;

public class MovieResponseDto {
    private String id;
    private String title;
    private String trailerSource;
    private String posterSource;
    private String description;
    private String genre;
    private String category;
    private Double rating;
    private LocalDate releaseDate;
    private String movieStatus;
    private String duration;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTrailerSource() {
        return trailerSource;
    }

    public void setTrailerSource(String trailerSource) {
        this.trailerSource = trailerSource;
    }

    public String getPosterSource() {
        return posterSource;
    }

    public void setPosterSource(String posterSource) {
        this.posterSource = posterSource;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMovieStatus() {
        return movieStatus;
    }

    public void setMovieStatus(String movieStatus) {
        this.movieStatus = movieStatus;
    }

    public MovieResponseDto() {
    }
}
