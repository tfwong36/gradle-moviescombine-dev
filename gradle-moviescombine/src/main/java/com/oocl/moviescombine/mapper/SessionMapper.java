package com.oocl.moviescombine.mapper;

import com.oocl.moviescombine.dto.SessionResponse;
import com.oocl.moviescombine.entity.Session;
import com.oocl.moviescombine.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SessionMapper {
    @Autowired
    SessionService sessionService;
    public SessionResponse toSessionResponse(Session session){
        SessionResponse sessionResponse = new SessionResponse();
        sessionResponse.setHasRemainSeat(session.getRemainingSeats().size() > 1);
        sessionResponse.setId(session.getId());
        sessionResponse.setCinemaId(session.getCinemaId());
        sessionResponse.setPrice(session.getPrice());
        sessionResponse.setShowDateTimeHkt(session.getShowDateTimeHkt());
        sessionResponse.setMovieId(session.getMovieId());
        return sessionResponse;
    }
}
