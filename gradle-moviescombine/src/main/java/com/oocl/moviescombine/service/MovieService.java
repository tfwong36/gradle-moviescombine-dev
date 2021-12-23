package com.oocl.moviescombine.service;

import com.oocl.moviescombine.dto.MovieResponseDto;
import com.oocl.moviescombine.entity.Movie;
import com.oocl.moviescombine.exception.NoMovieFoundException;
import com.oocl.moviescombine.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    private MovieRepository movieRepository;
    @Autowired
    SessionService sessionService;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAllMovies(){
        return movieRepository.findAll();
    }

    public Movie create(Movie movie) {
        return movieRepository.insert(movie);
    }

    public Movie getById(String id) {
        return movieRepository.findById(id).orElseThrow(NoMovieFoundException::new);
    }
}
