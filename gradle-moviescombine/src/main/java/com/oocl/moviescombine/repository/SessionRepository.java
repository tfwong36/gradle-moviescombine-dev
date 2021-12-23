package com.oocl.moviescombine.repository;

import com.oocl.moviescombine.entity.Session;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface SessionRepository extends MongoRepository<Session, String> {
    List<Session> findAllByMovieId(String movieId);
}
