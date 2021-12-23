package com.oocl.moviescombine.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;


@Document("movie")
public class Movie {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String title;
    private String trailerSource;
    private String posterSource;
    private String description;
    private String genre; //Action//Romance
    private String category;
    private Double rating; //1.5stars
    private LocalDate releaseDate;
    private String duration;

    public Movie() {
    }

    public Movie(String title, String posterSource, String trailerSource, String description, String genre, String category, Double rating, LocalDate releaseDate) {
        this.title = title;
        this.trailerSource = trailerSource;
        this.posterSource = posterSource;
        this.description = description;
        this.genre = genre;
        this.category = category;
        this.rating = rating;
        this.releaseDate = releaseDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        duration = duration;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTrailerSource() {
        return trailerSource;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }

    public String getCategory() {
        return category;
    }

    public Double getRating() {
        return rating;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTrailerSource(String trailerSource) {
        this.trailerSource = trailerSource;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getPosterSource() {
        return posterSource;
    }

    public void setPosterSource(String posterSource) {
        this.posterSource = posterSource;
    }
}
