package com.oocl.moviescombine.service;

import com.oocl.moviescombine.entity.Cinema;
import com.oocl.moviescombine.exception.NoSuchCinemaException;
import com.oocl.moviescombine.repository.CinemaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {

    private CinemaRepository cinemaRepository;

    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public List<Cinema> findAll() {
        return cinemaRepository.findAll();
    }

    public Cinema findById(String id) {
        return cinemaRepository.findById(id).orElseThrow(NoSuchCinemaException::new);
    }

    public Cinema saveNewCinema(Cinema newCinema) {
        return cinemaRepository.save(newCinema);
    }

    public Cinema updateCinema(String id, Cinema cinemaPatch) {
        Cinema originCinema = cinemaRepository.findById(id).orElseThrow(NoSuchCinemaException::new);

        if(cinemaPatch.getLocation() != null){
            originCinema.setLocation(cinemaPatch.getLocation());
        }

        if(cinemaPatch.getName() != null){
            originCinema.setLocation(cinemaPatch.getLocation());
        }

        return cinemaRepository.save(originCinema);
    }
}