package com.oocl.moviescombine.controller;

import com.oocl.moviescombine.dto.CreateSessionRequest;
import com.oocl.moviescombine.dto.ReserveSeatRequest;
import com.oocl.moviescombine.dto.SessionResponse;
import com.oocl.moviescombine.entity.Session;
import com.oocl.moviescombine.mapper.SessionMapper;
import com.oocl.moviescombine.service.SessionService;
import org.apache.tomcat.jni.Local;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/sessions")
public class SessionController {
    private SessionService sessionService;
    private SessionMapper sessionMapper;

    public SessionController(SessionService sessionService, SessionMapper sessionMapper) {
        this.sessionService = sessionService;
        this.sessionMapper = sessionMapper;
    }

    @GetMapping
    public List<SessionResponse> getAllSessionsOptionalByDate(@RequestParam(required = false) String date,
                                                              @RequestParam(required = false) String cinemaid,
                                                              @RequestParam(required = false) String movieid) {
        if (movieid !=null && !movieid.isEmpty()){
            return sessionService.findAll().stream().filter(session -> {
                return session.getMovieId().equals(movieid);
            }).map(item->sessionMapper.toSessionResponse(item)).collect(Collectors.toList());
        }
        if (cinemaid !=null && !cinemaid.isEmpty()){
            return sessionService.findAll().stream().filter(session -> {
                return session.getCinemaId().equals(cinemaid);
            }).map(item->sessionMapper.toSessionResponse(item)).collect(Collectors.toList());
        }
        if (date !=null && !date.isEmpty()){
            List<String> splitDate = Arrays.asList(date.split("-"));
            LocalDate inputDate = LocalDate.of(Integer. parseInt(splitDate.get(0)), Integer. parseInt(splitDate.get(1)), Integer. parseInt(splitDate.get(2)));
            return sessionService.findAll().stream().filter(session -> {
                return session.getShowDateTimeHkt().toLocalDate().equals(inputDate);
            }).map(item->sessionMapper.toSessionResponse(item)).collect(Collectors.toList());
        }
        return sessionService.findAll().stream().map(item->sessionMapper.toSessionResponse(item)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Session getSessionById(@PathVariable String id){
        return sessionService.findById(id);
    }

    @PostMapping("/{id}")
    public Boolean checkSeats(@PathVariable String id, @RequestBody ReserveSeatRequest reserveSeatRequest){
        return sessionService.checkSeats(id, reserveSeatRequest);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    public Session reserveSeat(@PathVariable String id, @RequestBody ReserveSeatRequest reserveSeatRequest){
        return sessionService.reserveSeat(id, reserveSeatRequest);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Session createSession(@RequestBody CreateSessionRequest createSessionRequest){
        return sessionService.createSession(
                                new Session(createSessionRequest.getCinemaId(),
                                createSessionRequest.getMovieId(),
                                createSessionRequest.getShowDateTimeHkt(),
                                createSessionRequest.getPrice(),
                                createSessionRequest.getRemainingSeats())
        );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteSession(@PathVariable String id){
        sessionService.deleteSession(id);
    }

    @GetMapping("/{id}/seats")
    public List<String> getSeatsById(@PathVariable String id){
        return sessionService.findById(id).getRemainingSeats();
    }

}
