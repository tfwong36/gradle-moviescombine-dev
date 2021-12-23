package com.oocl.moviescombine.service;


import com.oocl.moviescombine.dto.ReserveSeatRequest;
import com.oocl.moviescombine.entity.Session;
import com.oocl.moviescombine.exception.NoSessionFoundException;
import com.oocl.moviescombine.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class SessionService {
    private SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<Session> findAll(){
        return sessionRepository.findAll();
    }

    public boolean findLastShowingDateByMovieId(String movieId){
        List<Session> sessions = sessionRepository.findAllByMovieId(movieId);
        if(sessions.isEmpty()) {
            return false;
        } else{
            sessions.sort(Comparator.comparing(Session::getShowDateTimeHkt).reversed());
            LocalDate localDate = sessions.get(0).getShowDateTimeHkt().toLocalDate();
            return localDate.compareTo(LocalDate.now()) >= 0;
        }
    }

    public Session findById(String id) {
        return sessionRepository.findById(id).orElseThrow(NoSessionFoundException::new);
    }

    public Boolean checkSeats(String id, ReserveSeatRequest reserveSeatRequest) {
        Session session = findById(id);
        ArrayList<String> remainSeats = new ArrayList<String>(session.getRemainingSeats());
        for (String seat : reserveSeatRequest.getSeatNumbers()){
            if (!remainSeats.contains(seat)){
                return false;
            }
        }
        return true;
    }

    public Session reserveSeat(String id, ReserveSeatRequest reserveSeatRequest) {
        Session session = findById(id);
        String operation = reserveSeatRequest.getOperation();
        ArrayList<String> remainSeats = new ArrayList<String>(session.getRemainingSeats());
        if (operation.equals("a")){
            remainSeats.addAll(reserveSeatRequest.getSeatNumbers());
        } else if (operation.equals("r")){
            reserveSeatRequest.getSeatNumbers().forEach(remainSeats::remove);
        }
        session.setRemainingSeats(remainSeats);
        sessionRepository.save(session);
        return session;
    }

    public Session createSession(Session session) {
        sessionRepository.insert(session);
        return session;
    }

    public void deleteSession(String id) {
        Session session = findById(id);
        sessionRepository.deleteById(id);
    }
}
