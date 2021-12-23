package com.oocl.moviescombine.service;

import com.oocl.moviescombine.entity.Food;
import com.oocl.moviescombine.repository.FoodRepository;
import com.oocl.moviescombine.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class FoodService {
    private FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> findAllFoods() {
        return foodRepository.findAll();
    }

    public Food createFood(Food food) {
        return foodRepository.insert(food);
    }
}
