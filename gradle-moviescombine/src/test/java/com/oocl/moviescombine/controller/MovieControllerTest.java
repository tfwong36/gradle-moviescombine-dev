package com.oocl.moviescombine.controller;

import com.oocl.moviescombine.entity.Movie;
import com.oocl.moviescombine.entity.Session;
import com.oocl.moviescombine.repository.MovieRepository;
import com.oocl.moviescombine.repository.SessionRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    SessionRepository sessionRepository;

    @BeforeEach
    void cleanRepository() {
        movieRepository.deleteAll();
        sessionRepository.deleteAll();
    }

    @Test
    void should_get_all_movies_when_perform_get_given_movie() throws Exception {
        //given
        Movie movie1 = new Movie("Spider Man", "", "https://youtube.com", "Hello Spider", "IIA", "Action", 4.5, LocalDate.now());
        Movie movie2 = new Movie("Spider Man II","", "https://youtube.com", "Hello Spider II", "IIA", "Action", 4.1, LocalDate.now().plusDays(1));
        movieRepository.insert(movie1);
        movieRepository.insert(movie2);

        sessionRepository.insert(new Session("61c02b37f4d70de6e4b7706a", movieRepository.findAll().get(0).getId(), LocalDateTime.now(), 90, new ArrayList<>()));

        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.get("https://dev-moviescombine-api.herokuapp.com/movies?showing=true"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").isString())
                .andExpect(jsonPath("$[0].title").value("Spider Man"))
                .andExpect(jsonPath("$[0].movieStatus").value("Showing"))
                .andExpect(jsonPath("$[1].movieStatus").value("Upcoming"));
    }

}
