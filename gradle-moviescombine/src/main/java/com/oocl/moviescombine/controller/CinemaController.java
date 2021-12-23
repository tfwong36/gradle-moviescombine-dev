package com.oocl.moviescombine.controller;

import com.oocl.moviescombine.entity.Cinema;
import com.oocl.moviescombine.service.CinemaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/cinemas")
public class CinemaController {
    private CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping
    public List<Cinema> getAllCinema() {
        return cinemaService.findAll();
    }

    @GetMapping("/{id}")
    public Cinema getCinemaById(@PathVariable String id) {
        return cinemaService.findById(id);
    }

    @PostMapping
    public Cinema saveNewCinema(@RequestBody Cinema newCinema){
        return cinemaService.saveNewCinema(newCinema);
    }

    @PutMapping("/{id}")
    public Cinema updateCinema(@PathVariable String id , @RequestBody Cinema cinemaPatch){
        return cinemaService.updateCinema(id , cinemaPatch);
    }
}