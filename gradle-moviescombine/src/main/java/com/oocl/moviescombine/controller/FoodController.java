package com.oocl.moviescombine.controller;

import com.oocl.moviescombine.dto.MovieResponseDto;
import com.oocl.moviescombine.entity.Food;
import com.oocl.moviescombine.entity.Movie;
import com.oocl.moviescombine.service.FoodService;
import com.oocl.moviescombine.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/foods")
public class FoodController {
    private FoodService foodService;
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public List<Food> getAllFoods() {
        return foodService.findAllFoods().stream().collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Food getAllFoods(@RequestBody Food food) {
        return foodService.createFood(food);
    }
}
