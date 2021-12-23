package com.oocl.moviescombine.controller;

import com.oocl.moviescombine.repository.MovieRepository;
import com.oocl.moviescombine.repository.SessionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class SessionControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    SessionRepository sessionRepository;

    @Test
    void should_return_all_sessions_when_perform_get_all_sessions_given_sessions() {
        //given

        //when

        //then
    }

}
