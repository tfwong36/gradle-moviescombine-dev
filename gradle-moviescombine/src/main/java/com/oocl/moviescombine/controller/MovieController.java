package com.oocl.moviescombine.controller;

import com.oocl.moviescombine.dto.MovieResponseDto;
import com.oocl.moviescombine.entity.Movie;
import com.oocl.moviescombine.mapper.MovieMapper;
import com.oocl.moviescombine.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieMapper movieMapper;
    private MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieResponseDto> getAllMovies() {
       return movieService.findAllMovies().stream().map(movie -> movieMapper.toResponseDto(movie)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MovieResponseDto getById(@PathVariable String id) {
        return movieMapper.toResponseDto(movieService.getById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.create(movie);
    }
}
