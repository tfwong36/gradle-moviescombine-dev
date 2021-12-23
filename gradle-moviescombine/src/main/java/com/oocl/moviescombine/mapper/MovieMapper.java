package com.oocl.moviescombine.mapper;

import com.oocl.moviescombine.dto.MovieResponseDto;
import com.oocl.moviescombine.entity.Movie;
import com.oocl.moviescombine.service.SessionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

@Component
public class MovieMapper {
    @Autowired
    SessionService sessionService;
    public MovieResponseDto toResponseDto(Movie movie) {
        MovieResponseDto movieResponseDto = new MovieResponseDto();
        BeanUtils.copyProperties(movie, movieResponseDto);
        movieResponseDto.setMovieStatus(getMovieStatus(movie));
        return movieResponseDto;
    }
    private String getMovieStatus(Movie movie) {
        if (ObjectUtils.isEmpty(movie.getReleaseDate())) {
            return "Outdated";
        }
        if (movie.getReleaseDate().compareTo(LocalDate.now()) > 0) {
            return "Upcoming";
        } else if (sessionService.findLastShowingDateByMovieId(movie.getId())) {
            return "Showing";
        }

        return "Outdated";
    }
}
