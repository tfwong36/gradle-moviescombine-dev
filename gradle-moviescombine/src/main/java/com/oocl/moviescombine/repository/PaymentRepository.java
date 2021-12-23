package com.oocl.moviescombine.repository;

import com.oocl.moviescombine.entity.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}