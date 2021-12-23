package com.oocl.moviescombine.service;

import com.oocl.moviescombine.entity.Movie;
import com.oocl.moviescombine.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
public class MovieServiceTest {
    @Mock
    MovieRepository movieRepository;

    @InjectMocks
    MovieService movieService;

    @Test
    void should_return_all_movie_when_find_all_movies_given_movies() {
        //given
        List<Movie> movies = new ArrayList<>();
        Movie movie1 = new Movie( "Spider Man", "","https://youtube.com", "Hello Spider", "IIA", "Action", 4.5, LocalDate.parse("2021-12-12"));
        Movie movie2 = new Movie("Spider Man II","", "https://youtube.com", "Hello Spider II", "IIA", "Action", 4.2, LocalDate.parse("2023-12-12"));
        movies.add(movie1);
        movies.add(movie2);

        given(movieRepository.findAll())
                .willReturn(movies);
        //when
        List<Movie> actual = movieService.findAllMovies();
        //then
        assertEquals(Arrays.asList(movie1, movie2), actual);
        assertEquals(movies.get(0).getTitle(), actual.get(0).getTitle());
        assertEquals(movies.get(0).getCategory(), actual.get(0).getCategory());
    }
}
