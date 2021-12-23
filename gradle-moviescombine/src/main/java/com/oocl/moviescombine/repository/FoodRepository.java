package com.oocl.moviescombine.repository;

import com.oocl.moviescombine.entity.Cinema;
import com.oocl.moviescombine.entity.Food;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodRepository extends MongoRepository<Food, String> {
}

